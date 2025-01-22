package com.first.ramSirRstApi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.first.ramSirRstApi.dto.BlogPostDTO;
import com.first.ramSirRstApi.dto.CommentDTO;
import com.first.ramSirRstApi.entities.BlogPost;
import com.first.ramSirRstApi.entities.Comments;
import com.first.ramSirRstApi.exception.ResourceNotFoundException;
import com.first.ramSirRstApi.payloads.BlogPostResponse;
import com.first.ramSirRstApi.repository.BlogPostRepo;
import com.first.ramSirRstApi.service.BlogPostService;

@Service
public class BlogPostServiceImpl implements BlogPostService {

	
	private BlogPostRepo blogPostRepo;

	
	@Autowired
	public BlogPostServiceImpl(BlogPostRepo blogPostRepo) {
		super();
		this.blogPostRepo = blogPostRepo;
	}
	
	@Autowired
	private CommentServiceImpl commentServiceImpl;

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
	   
		List<Comments>list=blogPost.getComments();
		List<CommentDTO>commentDTOList=list.stream().map(comment ->commentServiceImpl.mapEntityToDto(comment) ).toList();
	   
		//setting related comments list with related bolgpost  
		blogPostDto.setComments(commentDTOList);
	    //CommentDTO
		return blogPostDto;

	}

	@Override
	public BlogPostDTO findByBlogPostId(Integer id) {
		Optional<BlogPost> findById = blogPostRepo.findById(id);
		BlogPost blogPost = findById.orElseThrow(() -> new ResourceNotFoundException("BlogPost", "Id", id));
		return mapEntityToDto(blogPost);
	}

	@Override
	public List<BlogPostDTO> getAllBlogPost(PageRequest pageRequest) {
	   //normal way
		//List<BlogPost> findAll = blogPostRepo.findAll(pageRequest);
		
		
		
		
		//pagination
		Page<BlogPost> findAll = blogPostRepo.findAll(pageRequest);
		List<BlogPost>blogPosts=findAll.getContent();
		
		 List<BlogPostDTO> list = blogPosts.stream() .map(this::mapEntityToDto).collect(Collectors.toList());
		BlogPostResponse blogPostResponse= new BlogPostResponse();
		
		
		blogPostResponse.setPageNo(pageRequest.getPageNumber());
		blogPostResponse.setPageSize(pageRequest.getPageSize());
		
		
		//----------------------------------------------------------------
		
		// using stream
		return list;

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

	@Override
	public BlogPost findBlogPostId(Integer id) {
		Optional<BlogPost> findById = blogPostRepo.findById(id);
		BlogPost blogPost = findById.orElseThrow(() -> new ResourceNotFoundException("BlogPost", "Id", id));
	return blogPost;
	}

	@Override
	public void delete(BlogPost blogPost) {
		blogPostRepo.delete(blogPost);
		
	}

	@Override
	public BlogPostDTO deletePostById(Integer id) {
		BlogPost blogPost = blogPostRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("BlogPost", "Id", id));
		blogPostRepo.deleteById(id);
		return mapEntityToDto(blogPost);
	}

}
