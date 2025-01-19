package com.first.ramSirRstApi.service;

import java.util.List;

import com.first.ramSirRstApi.dto.BlogPostDTO;
import com.first.ramSirRstApi.entities.BlogPost;

public interface BlogPostService {
public BlogPostDTO createObject(BlogPostDTO blogPostDTO);

public BlogPostDTO findByBlogPostId(Integer id);

List<BlogPostDTO> getAllBlogPost();

BlogPostDTO updateBlogPost(BlogPostDTO blogPostDTO);
}
