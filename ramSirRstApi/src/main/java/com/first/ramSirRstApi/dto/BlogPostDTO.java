package com.first.ramSirRstApi.dto;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostDTO {
	
	private Integer Blogzid;
	
	@NotEmpty
	@Size(min = 2,message = "Title should be more than 2 character")
	private String title11;
	
	@NotEmpty
	@Size(min = 2,message = "Description should be more than 2 character")
	private String Description;
	
	@NotEmpty
	@Size(min = 10,message = "Content should be more than 10 character")
	private String content1;
	
	private List<CommentDTO> comments;
	
	@Override
	public String toString() {
		return "BlogPostDTO [Blogzid=" + Blogzid + ", title11=" + title11 + ", Description=" + Description
				+ ", content1=" + content1 + "]";
	}
	
	
}
