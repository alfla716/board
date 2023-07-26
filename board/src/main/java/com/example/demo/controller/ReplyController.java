package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.Board;
//import com.example.demo.model.entity.Board;
import com.example.demo.model.entity.Reply;
import com.example.demo.model.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/reply")
@Slf4j
public class ReplyController {
	
	private ReplyService service;
	
	@Autowired
	public ReplyController(ReplyService service) {
		this.service = service;
		
	}
	
	@GetMapping("/regist")
	public String registReply() {
		return "reply/regist";
//		return "http://localhost:8080/board/detail?no="+dto.getBoardNo();
	}
		
	
	
	 @PostMapping("/regist")
     public String doRegist(@ModelAttribute ReplyDto dto, Model model) {
		 service.writeReply(dto);
		 Page<Reply> replies = service.listReply(dto.getBoardNo());
//             return "redirect:/reply/list";
         return "redirect:http://localhost:8080/board/detail?no="+dto.getBoardNo();

     }
	 
//	@GetMapping("/list")
//	public String viewReply(@RequestParam int no, Model model) {
//		Optional<Reply> replies = service.listReply(no);
//		model.addAttribute("replies", replies);
//		return "reply/list";
////		return "http://localhost:8080/board/detail?no="+dto.getBoardNo();
//	}
	
//	@GetMapping("/list")
//	public String list(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
//		ReplyDto dto = new ReplyDto();
//		page--;
//		log.debug("page: {}",page);
//		Page<Reply> replyPageInfo = service.listReply(page);
//		model.addAttribute("replyPageInfo", replyPageInfo);
////		return "http://localhost:8080/board/detail?no="+dto.getBoardNo();
//		return "reply/list";
//	}
	 
//		@GetMapping("/list")
//		public String detail(@RequestParam("no") int no, Model model) {
//			log.debug("no: {}", no);
//			try {
//				Reply reply = service.detailReply(no);
//				model.addAttribute("reply",reply);
////				List<Reply> reply = null;
////				reply = replyService.
//				return "reply/list";
//			}catch(RuntimeException e){
//				return "/reply/list";
//			}
//			
//		}
	

}
