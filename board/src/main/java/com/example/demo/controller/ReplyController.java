package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.example.demo.model.dto.BoardDto;
import com.example.demo.model.dto.ReplyDto;
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
	}
	
//	@PostMapping("/regist")
//	public String doRegist(@ModelAttribute ReplyDto dto) {
//		service.writeReply(dto);
//		return "redirect:/reply/list";
//		
//	}
	
	 @PostMapping("/regist")
     public String doRegist(@ModelAttribute ReplyDto dto) {
             service.writeReply(dto);
//             return "redirect:/reply/list";
               return "redirect:http://localhost:8080/board/detail?no="+dto.getBoardNo();
     }
	
	@GetMapping("/list")
	public String list(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
		page--;
//		log.debug("page: {}",page);
		Page<Reply> pageInfo = service.listReply(page);
		model.addAttribute("pageInfo", pageInfo);
		return "reply/list";
	}
	

}
