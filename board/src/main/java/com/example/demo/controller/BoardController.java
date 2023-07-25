package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.BoardDto;
import com.example.demo.model.entity.Board;
import com.example.demo.model.entity.Reply;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.service.BoardService;
import com.example.demo.model.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {
	
	private BoardService service;
	private ReplyService replyService;
	
	@Autowired
	public BoardController(BoardService service, ReplyService replyService) {
		this.service = service;
		this.replyService = replyService;
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "board/registboard";
	}
	
	@PostMapping("/regist")
	public String doRegist(@ModelAttribute BoardDto dto) {
//		log.debug("전달 파라미터 확인: {}", dto);
		service.writeBoard(dto);
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public String list(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
		page--;
		log.debug("page: {}",page);
		Page<Board> pageInfo = service.listBoard(page);
		model.addAttribute("pageInfo", pageInfo);
		return "board/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("no") int no, Model model) {
		log.debug("no: {}", no);
		try {
			System.out.println("******1***");
			Board board = service.detailBoard(no);
			System.out.println("*********");
			System.out.println("----- " + board.getReplies());
			model.addAttribute("board",board);
			model.addAttribute("replys",board.getReplies());
//			List<Reply> reply = null;
//			reply = replyService.
			return "board/detail";
		}catch(RuntimeException e){
			return "/board/list";
		}
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {
		log.debug("board no: {}", no);
		service.deleteBoard(no);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto dto, Model model) {
		log.debug("board 수정: {}", dto);
		service.writeBoard(dto);
//		model.addAttribute("board", service.detailBoard(dto.getNo()));
		return "redirect:/board/detail?no="+dto.getNo();
		
	}
	
	

}
