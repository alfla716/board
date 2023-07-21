package com.example.demo.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
