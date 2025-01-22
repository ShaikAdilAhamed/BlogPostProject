package com.first.ramSirRstApi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.first.ramSirRstApi.dto.BlogPostDTO;
import com.first.ramSirRstApi.entities.BlogPost;

public interface BlogPostService {
public BlogPostDTO createObject(BlogPostDTO blogPostDTO);

public BlogPostDTO findByBlogPostId(Integer id);

List<BlogPostDTO> getAllBlogPost(PageRequest of);

BlogPostDTO updateBlogPost(BlogPostDTO blogPostDTO);

public BlogPost findBlogPostId(Integer blogPostId);

public void delete(BlogPost blogPost);

public BlogPostDTO deletePostById(Integer postId);
}
