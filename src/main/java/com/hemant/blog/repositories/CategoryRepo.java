package com.hemant.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemant.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
