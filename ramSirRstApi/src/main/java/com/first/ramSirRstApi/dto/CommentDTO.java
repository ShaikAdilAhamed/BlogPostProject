package com.first.ramSirRstApi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
	
	private Integer commentId;
	
	@NotEmpty
	@Size(min = 2,message = "Comment should be more than 2 character")
    private String comment;
	
	
    private Integer blogPostId;
    
}
