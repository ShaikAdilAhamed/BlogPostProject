package com.first.ramSirRstApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.ramSirRstApi.entities.BlogPost;
import com.first.ramSirRstApi.entities.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

	List<Comments> findByblogPost(BlogPost blogPostId);

	List<Comments> findByblogPostAndCommentId(BlogPost blogPost, Integer commentId);

}
