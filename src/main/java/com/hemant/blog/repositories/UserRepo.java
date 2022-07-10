package com.hemant.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemant.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
