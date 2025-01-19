package com.first.ramSirRstApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.ramSirRstApi.entities.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
