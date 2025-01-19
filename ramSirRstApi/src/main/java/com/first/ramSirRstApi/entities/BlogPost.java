package com.first.ramSirRstApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class BlogPost {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Blogzid;
	private String title11;
	private String Description;
	private String content1;
	//private 
}
