package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.service.UserService;

import jakarta.servlet.http.HttpSession;
//import jakarta.websocket.Session;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	private UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	
	@GetMapping("/join")
	public String joinForm() {
		return "user/join";
		
	}
	
	@PostMapping("/join")
	public String doJoin(@ModelAttribute UserDto dto, Model model) {
		log.debug("전달 파라미터 확인: {}", dto);
		try {
			service.join(dto);
			return "redirect:/";
			
		}catch(RuntimeException e){
			model.addAttribute("msg", dto.getId()+"는 이미 사용중");
			return "user/join";
		}
		
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute UserDto dto, Model model, HttpSession session) {
		log.debug("전달 파라미터 확인: {}", dto);
		try {
			UserDto result = service.login(dto);
			session.setAttribute("loginUser", result);
			return "redirect:/";
		}catch(RuntimeException e) {
			model.addAttribute("loginmsg", e.getMessage());
			return "index";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
		}
}
