package com.glits.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glits.learn.model.Users;


public interface UsersRepo extends JpaRepository<Users, Integer> {
	public Users findByEmail(String email);
//	public Users findById(Integer id);
}
