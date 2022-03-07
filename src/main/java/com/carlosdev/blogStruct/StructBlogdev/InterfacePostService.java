package com.carlosdev.blogStruct.StructBlogdev;

import com.carlosdev.blogStruct.StructBlogdev.entity.Post;

import java.util.List;

public interface InterfacePostService {

    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
}
