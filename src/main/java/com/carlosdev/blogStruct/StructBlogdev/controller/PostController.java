package com.carlosdev.blogStruct.StructBlogdev.controller;


import com.carlosdev.blogStruct.StructBlogdev.InterfacePostService;
import com.carlosdev.blogStruct.StructBlogdev.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.time.LocalDate;
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
    // PEGANDO O POST PELO ID
    @RequestMapping(value = "v1posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostsById(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("contentDetails");
        Post postContentDetails = postService.findById(id);
        mv.addObject("contentDetails",postContentDetails);
        return mv;

    }


    @RequestMapping(value = "/v1newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "formulario";
    }


    @RequestMapping(value = "/v1newpost", method = RequestMethod.POST)
    public String SavePostForm(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        // VALIDAÇÃO DO POST, NO CASO UMA REGRA DE NEGOCIO QUE PODE IR PARA O SERVICE
        if (result.hasErrors()){

            attributes.addFlashAttribute("message","Verifique se os campos obrigatórios foram preenchidos.");
            return "redirect:/v1newpost";
        }

        //  INSERINDO DATA NO POST JA QUE A MESMA NÃO ESTARÁ NO FORMULARIO
        post.setPostDate(LocalDate.now());

        // SALVANDO O POST
        postService.save(post);

        //RETOTNANDO A PAGINA COM OS POSTS
        return "redirect:/v1posts";
    }

}
