package com.carlosdev.blogStruct.StructBlogdev.repository;

import com.carlosdev.blogStruct.StructBlogdev.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfacePostRepository extends JpaRepository<Post, Long> {
}
