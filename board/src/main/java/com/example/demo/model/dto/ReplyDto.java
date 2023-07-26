package com.example.demo.model.dto;

import com.example.demo.model.entity.Reply;

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
public class ReplyDto {
	private int no;
	private String content;
	private String userId;
	private int boardNo;
	
	public Reply toEntity() {
		Reply reply = new Reply();
		reply.setNo(this.getNo());
		reply.setContent(this.getContent());
		return reply;
	}

}
