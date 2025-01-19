package com.first.ramSirRstApi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.ramSirRstApi.dto.BlogPostDTO;
import com.first.ramSirRstApi.entities.BlogPost;
import com.first.ramSirRstApi.exception.ResourceNotFoundException;
import com.first.ramSirRstApi.repository.BlogPostRepo;
import com.first.ramSirRstApi.service.BlogPostService;

@Service
public class BolhPostServiceImpl implements BlogPostService {

	private BlogPostRepo blogPostRepo;

	@Autowired
	public BolhPostServiceImpl(BlogPostRepo blogPostRepo) {
		super();
		this.blogPostRepo = blogPostRepo;
	}

	@Override
	public BlogPostDTO createObject(BlogPostDTO blogPostDTO) {
		BlogPost save = blogPostRepo.save(mapDtoToEntity(blogPostDTO));
		return mapEntityToDto(save);
	}

	private BlogPost mapDtoToEntity(BlogPostDTO blogPostDTO) {
		BlogPost blogPost = new BlogPost();
		blogPost.setContent1(blogPostDTO.getContent1());
		blogPost.setDescription(blogPostDTO.getDescription());
		blogPost.setTitle11(blogPostDTO.getTitle11());
		blogPost.setBlogzid(blogPostDTO.getBlogzid());
		return blogPost;

	}

	private BlogPostDTO mapEntityToDto(BlogPost blogPost) {
		BlogPostDTO blogPostDto = new BlogPostDTO();
		blogPostDto.setContent1(blogPost.getContent1());
		blogPostDto.setDescription(blogPost.getDescription());
		blogPostDto.setTitle11(blogPost.getTitle11());
		blogPostDto.setBlogzid(blogPost.getBlogzid());
		return blogPostDto;

	}

	@Override
	public BlogPostDTO findByBlogPostId(Integer id) {
		Optional<BlogPost> findById = blogPostRepo.findById(id);
		BlogPost blogPost = findById.orElseThrow(() -> new ResourceNotFoundException("BlogPost", "Id", id));
		return mapEntityToDto(blogPost);
	}

	@Override
	public List<BlogPostDTO> getAllBlogPost() {
		List<BlogPost> findAll = blogPostRepo.findAll();
		// using stream
		return findAll.stream().map(blogpost -> mapEntityToDto(blogpost)).toList();

		// using core java
//		List<BlogPostDTO> blogpostDtos = new ArrayList<>();
//		for (BlogPost blogPost : findAll) {
//			blogpostDtos.add(mapEntityToDto(blogPost));
//
//		}
//		return blogpostDtos;
	}

	@Override
	public BlogPostDTO updateBlogPost(BlogPostDTO blogPostDTO) {
		Optional<BlogPost> findbyId = blogPostRepo.findById(blogPostDTO.getBlogzid());
		// check if id is exist or not if not then throw error
		//in single line 0
		//findbyId.orElseThrow(() -> new ResourceNotFoundException("BlogPost", "Id", blogPostDTO.getBlogzid()));

		//in simplified way
		BlogPost update = null;
		if (findbyId.isPresent()) {

			update = blogPostRepo.save(mapDtoToEntity(blogPostDTO));
		} else {
			throw new ResourceNotFoundException("BlogPost", "Id", blogPostDTO.getBlogzid());
		}
		return mapEntityToDto(update);
	}

}
