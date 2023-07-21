package com.example.demo.model.dto;

import com.example.demo.model.entity.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyDto {
	private Integer no;
	private String content;
	private String userId;
	private Integer boardNo;
	
	public Reply toEntity() {
		Reply reply = new Reply();
		reply.setNo(this.getNo());
		reply.setContent(this.getContent());
		return reply;
	}

}
