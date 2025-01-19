package com.first.ramSirRstApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.ramSirRstApi.dto.BlogPostDTO;
import com.first.ramSirRstApi.dto.CommentDTO;
import com.first.ramSirRstApi.service.CommentService;

@RestController
@RequestMapping("/api/posts")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/{postId}/comments")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO,@PathVariable Integer postId) {

		if(postId.equals(commentDTO.getBlogPostId()))
		{
		CommentDTO createComment = commentService.createComment(commentDTO);
		return new ResponseEntity(createComment, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity("Post Id Not Match", HttpStatus.BAD_REQUEST);
		}
		
	}
}
