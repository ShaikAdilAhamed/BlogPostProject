package com.first.ramSirRstApi.dto;
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
	private String title11;
	private String Description;
	private String content1;
	@Override
	public String toString() {
		return "BlogPostDTO [Blogzid=" + Blogzid + ", title11=" + title11 + ", Description=" + Description
				+ ", content1=" + content1 + "]";
	}
	
	
}
