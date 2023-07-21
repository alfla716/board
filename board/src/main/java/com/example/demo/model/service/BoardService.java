package com.example.demo.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.BoardDto;
import com.example.demo.model.entity.Board;
import com.example.demo.model.entity.User;
import com.example.demo.model.repo.BoardRepository;
import com.example.demo.model.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class BoardService {
	private UserRepository urepo;
	private BoardRepository brepo;
	
	@Autowired
	public BoardService(UserRepository urepo, BoardRepository brepo) {
		this.urepo = urepo;
		this.brepo = brepo;
	}
	
	@Transactional
	public void writeBoard(BoardDto dto) {
		String userId = dto.getUserId();
		User user = urepo.getReferenceById(userId);
		Board board = dto.toEntity();
		// user는 방금 생김
		board.setUser(user);
		brepo.saveAndFlush(board);
	}
	
	public Page<Board> listBoard(int page){
		Pageable pageable = PageRequest.of(page, 5, Direction.DESC, "no");
		Page<Board> pageInfo = brepo.findAll(pageable);
		return pageInfo;
	}
//		return brepo.findAll(pageable);
		
	
	
	public Board detailBoard(int no) {
		Optional<Board> option = brepo.findById(no);
		if(option.isPresent()) {
			return option.get();
		}else {
			throw new RuntimeException(no+"글이 지워졌나봐요");
		}
	}
	
	public void deleteBoard(int no) {
		brepo.deleteById(no);
		
	}

}
