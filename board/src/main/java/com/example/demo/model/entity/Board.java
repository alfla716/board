package com.example.demo.model.entity;


import java.util.List;

import com.example.demo.model.dto.BoardDto;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.*;
//import jakarta.persistence.FetchType;
import lombok.*;

//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@ToString(exclude = "user")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	private String title;
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;
	
	@OneToMany(mappedBy = "board")
	List<Reply> replies;

	public BoardDto toDto() {
		BoardDto dto = new BoardDto();
		dto.setNo(this.getNo());
		dto.setTitle(this.getTitle());
		dto.setContent(this.getContent());
		dto.setUserId(this.getUser().getId());
		return dto;
	}


}
