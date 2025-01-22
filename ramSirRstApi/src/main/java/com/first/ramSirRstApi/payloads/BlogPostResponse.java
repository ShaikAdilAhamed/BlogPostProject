package com.first.ramSirRstApi.payloads;

import java.util.List;

import com.first.ramSirRstApi.dto.BlogPostDTO;

import lombok.Data;

@Data
public class BlogPostResponse {

	private List<BlogPostDTO> blogPost;
	private int pageNo;
	private int pageSize;
	private int totalElements;
	private int last;
	
	
	
}
