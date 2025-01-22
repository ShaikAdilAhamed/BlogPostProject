package com.first.ramSirRstApi.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class BlogPost {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer blogzid;
	private String title11;
	private String Description;
	private String content1;
	
	@OneToMany(mappedBy = "blogPost",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Comments>comments;
	//private 
}
