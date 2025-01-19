package com.first.ramSirRstApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.ramSirRstApi.dto.BlogPostDTO;
import com.first.ramSirRstApi.dto.CommentDTO;
import com.first.ramSirRstApi.entities.BlogPost;
import com.first.ramSirRstApi.entities.Comments;
import com.first.ramSirRstApi.repository.CommentRepository;
import com.first.ramSirRstApi.service.BlogPostService;
import com.first.ramSirRstApi.service.CommentService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private BlogPostService blogPostService;

	@Override
	public CommentDTO createComment(CommentDTO commentDTO) {
		Comments save = commentRepository.save(mapDtoToEntity(commentDTO));
		return mapEntityToDto(save);
	}

	private CommentDTO mapEntityToDto(Comments comments) {
		CommentDTO commentDTO=new CommentDTO();
		commentDTO.setBlogPostId(comments.getBlogPost().getBlogzid());
		commentDTO.setComment(comments.getComment());
		commentDTO.setCommentId(comments.getCommentId());
		return commentDTO;
	}

	private Comments mapDtoToEntity(CommentDTO commentDTO) {
		BlogPost blogPost = blogPostService.findBlogPostId(commentDTO.getBlogPostId());

		Comments comments = new Comments();
		comments.setComment(commentDTO.getComment());
		comments.setBlogPost(blogPost);
		return comments;
	}

}
