package com.first.ramSirRstApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.first.ramSirRstApi.entities.BlogPost;
import com.first.ramSirRstApi.entities.Comments;

import jakarta.transaction.Transactional;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

	List<Comments> findByblogPost(BlogPost blogPostId);

	List<Comments> findByblogPostAndCommentId(BlogPost blogPost, Integer commentId);
    
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Comments c WHERE c.blogPost.blogzid = :blogzid AND c.commentId = :commentId")
	void deleteByBlogpostIdAndCommentId(@Param("blogzid") Integer blogPostId, @Param("commentId") Integer commentId);





}
