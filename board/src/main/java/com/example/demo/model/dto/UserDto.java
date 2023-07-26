package com.example.demo.model.dto;


import com.example.demo.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// Database와 무관하게 화면 --> Service까지 사용
public class UserDto {
	private String id;
	private String name;
	private String pass;
	private String grade;
	
	public User toEntity() {
		User user = new User();
		user.setId(this.getId());
		user.setName(this.getName());
		user.setPass(this.getPass());
		user.setGrade(this.getGrade());
		return user;
		
	}

}