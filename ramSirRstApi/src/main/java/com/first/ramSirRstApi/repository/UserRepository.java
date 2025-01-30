package com.first.ramSirRstApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.ramSirRstApi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsernameOrEmail(String userName,String email);
}
