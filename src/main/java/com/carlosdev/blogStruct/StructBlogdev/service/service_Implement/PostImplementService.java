package com.carlosdev.blogStruct.StructBlogdev.service.service_Implement;

import com.carlosdev.blogStruct.StructBlogdev.InterfacePostService;
import com.carlosdev.blogStruct.StructBlogdev.entity.Post;
import com.carlosdev.blogStruct.StructBlogdev.repository.InterfacePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImplementService implements InterfacePostService {

    // INJEÇÃO DO REPOSITORIO JPA RE.....
    @Autowired
    private InterfacePostRepository postRepository;


    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }
}
