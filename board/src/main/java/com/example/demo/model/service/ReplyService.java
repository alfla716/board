package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ReplyDto;
import com.example.demo.model.entity.Board;
import com.example.demo.model.entity.Reply;
import com.example.demo.model.entity.User;
import com.example.demo.model.repo.BoardRepository;
import com.example.demo.model.repo.ReplyRepository;
import com.example.demo.model.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ReplyService {
	private UserRepository urepo;
	private BoardRepository brepo;
	private ReplyRepository rrepo;
	
	@Autowired
	public ReplyService(UserRepository urepo, BoardRepository brepo, ReplyRepository rrepo) {
		this.urepo = urepo;
		this.brepo = brepo;
		this.rrepo = rrepo;
	}
	
	@Transactional
	public void writeReply(ReplyDto dto) {
		String userId = dto.getUserId();
		Integer boardNo = dto.getBoardNo();
		User user = urepo.getReferenceById(userId);
		Board board = brepo.getReferenceById(boardNo);
		Reply reply = dto.toEntity();
		reply.setUser(user);
		reply.setBoard(board);
		rrepo.saveAndFlush(reply);
	}
	
	public Page<Reply> listReply(int page){
		Pageable pageable = PageRequest.of(page, 5, Direction.DESC, "no");
		Page<Reply> replyPageInfo = rrepo.findAll(pageable);
		return replyPageInfo;
	}
	
	public void deleteReply(int no) {
		rrepo.deleteById(no);
	}

}
