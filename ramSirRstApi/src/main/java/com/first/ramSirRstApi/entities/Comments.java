package com.first.ramSirRstApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer commentId;
	    private String comment;
	    
	    @ManyToOne
	    @JoinColumn(name = "Blogzid")
	    private BlogPost blogPost;
	
}
