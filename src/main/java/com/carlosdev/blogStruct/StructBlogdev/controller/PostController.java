package com.carlosdev.blogStruct.StructBlogdev.controller;


import com.carlosdev.blogStruct.StructBlogdev.InterfacePostService;
import com.carlosdev.blogStruct.StructBlogdev.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class PostController {

    // INSTACIAR O SERVICE
    @Autowired
    private InterfacePostService postService;


    @RequestMapping(value = "v1posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("index");
        List<Post> posts = postService.findAll();
        mv.addObject("posts",posts);
        return mv;

    }
}
