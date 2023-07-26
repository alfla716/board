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
//import com.example.demo.model.dto.BoardDto;
import com.example.demo.model.dto.ReplyDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.Board;
//import com.example.demo.model.entity.Board;
import com.example.demo.model.entity.Reply;
import com.example.demo.model.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	private ReplyService service;
	
	@Autowired
	public ReplyController(ReplyService service) {
		this.service = service;
		
	}
	
	@GetMapping("/regist")
	public String registReply() {
		return "reply/register";
//		return "http://localhost:8080/board/detail?no="+dto.getBoardNo();
	}
		
	
	
//	@PostMapping("/regist")
//	public String doRegist(@ModelAttribute ReplyDto dto) {
//		service.writeReply(dto);
//		return "redirect:/reply/list";
//		
//	}
	
	 @PostMapping("/regist")
     public String doRegist(@ModelAttribute ReplyDto dto, Model model) {
		 
		 service.writeReply(dto);
		 service.listReply(dto.getBoardNo());
//             return "redirect:/reply/list";
         return "redirect:http://localhost:8080/board/detail?no="+dto.getBoardNo();

     }
	 
//	@GetMapping("/regist")
//	public String viewReply() {
//		List<Reply> reply = null;
//		reply = ReplyService.
//		return "reply/register";
////		return "http://localhost:8080/board/detail?no="+dto.getBoardNo();
//	}
	
//	@GetMapping("/regist")
//	public String list(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
//		ReplyDto dto = new ReplyDto();
//		page--;
////		log.debug("page: {}",page);
//		Page<Reply> pageInfo = service.listReply(page);
//		model.addAttribute("pageInfo", pageInfo);
//		return "http://localhost:8080/board/detail?no="+dto.getBoardNo();
//	}
	 
	 @GetMapping("/delete")
	 public String delete(@RequestParam int no, @ModelAttribute ReplyDto dto, Model model) {
		 service.deleteReply(no);
//		 return "redirect:http://localhost:8080/board/detail?no="+dto.getBoardNo();
		 return "redirect:/board/list";
	 }
	

}
