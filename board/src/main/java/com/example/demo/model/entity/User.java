package com.example.demo.model.entity;


import java.util.List;

import com.example.demo.model.dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "boards")
//Database와 관련되며 Service --> Repository에서 사용
public class User {
	@Id
	private String id;
	private String name;
	private String pass;
	private String grade;
	
	@OneToMany(mappedBy = "user")
	List<Board> boards;
	
	@OneToMany(mappedBy = "user")
	List<Reply> replies;

	public UserDto toDto() {
		UserDto user = new UserDto();
		user.setId(this.getId());
		user.setName(this.getName());
		user.setPass(this.getPass());
		user.setGrade(this.getGrade());
		return user;

	}
}
