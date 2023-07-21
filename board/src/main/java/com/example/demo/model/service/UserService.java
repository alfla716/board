package com.example.demo.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	private UserRepository repo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	@Transactional // DML은 언제나 @Transactional
	public void join(UserDto dto) {
		User user = dto.toEntity();
		if(repo.findById(user.getId()).isPresent()) {
			throw new RuntimeException("이미 존재하는 사용자입니다.");
		}
		
		
		repo.saveAndFlush(user);
	}
	
	public UserDto login(UserDto dto) {
		Optional<User> result = repo.findById(dto.getId());
		// result가 비어있으면 예외처리, 아니면 pass 비교 --> 같으면 UserDto 반환
		if(result.isPresent()) {
			User selected = result.get();
			if(selected.getPass().equals(dto.getPass())) {
				return selected.toDto();
			}
		}
		throw new RuntimeException("아이디 또는 비밀번호를 확인하세요");
	}

}
