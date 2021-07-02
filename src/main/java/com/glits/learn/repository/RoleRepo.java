package com.glits.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glits.learn.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
