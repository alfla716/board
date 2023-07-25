package com.example.demo.model.entity;

import com.example.demo.model.dto.ReplyDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@ToString(exclude = "user")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_no") // This references the 'no' column in the 'Board' table
    private Board board;

    public ReplyDto toDto() {
        ReplyDto dto = new ReplyDto();
        dto.setNo(this.getNo());
        dto.setContent(this.getContent());
        dto.setBoardNo(this.getBoard().getNo());
        dto.setUserId(this.getUser().getId());
        return dto;
    }
}

