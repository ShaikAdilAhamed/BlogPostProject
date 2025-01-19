package com.first.ramSirRstApi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.ramSirRstApi.entities.BlogPost;
@Repository
public interface BlogPostRepo extends JpaRepository<BlogPost,Integer> {

}
