package com.first.ramSirRstApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
	private Integer commentId;
    private String comment;
    private Integer blogPostId;
    
}
