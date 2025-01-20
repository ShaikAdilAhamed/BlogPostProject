package com.first.ramSirRstApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first.ramSirRstApi.dto.BlogPostDTO;
import com.first.ramSirRstApi.service.BlogPostService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {
	@Autowired
	private BlogPostService blogPostService;

	@GetMapping("/{postId}")
	public ResponseEntity<BlogPostDTO> findGlog(@PathVariable("postId") Integer id) {

		BlogPostDTO getById=blogPostService.findByBlogPostId(id);
		return new ResponseEntity(getById, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<BlogPostDTO> createBlog(@RequestBody BlogPostDTO blogPostDTO) {

		BlogPostDTO createBlogPost = blogPostService.createObject(blogPostDTO);
		return new ResponseEntity(createBlogPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<BlogPostDTO> findAllGlog() {

		List<BlogPostDTO> getById=blogPostService.getAllBlogPost();
		getById.forEach(s -> System.out.println(s));
		return new ResponseEntity(getById, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<BlogPostDTO> updateBlogPost(@RequestBody BlogPostDTO blogPostDTO) {

		BlogPostDTO getById=blogPostService.updateBlogPost(blogPostDTO);
		
		return new ResponseEntity(getById, HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePostById(@PathVariable("postId") Integer postId) {
		BlogPostDTO deletePostById = blogPostService.deletePostById(postId);
		return new ResponseEntity("Data Deleted successully",HttpStatus.OK);
	}

}
