package com.carlosdev.blogStruct.StructBlogdev.utils;

import com.carlosdev.blogStruct.StructBlogdev.entity.Post;
import com.carlosdev.blogStruct.StructBlogdev.repository.InterfacePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MOCAGEM {

    // CRIANDO MOCAGEM NO REPOSITORIO
    @Autowired
    InterfacePostRepository postRepository;

    // TUDO QUE FOR INFORMADO NO METODO VAI SUBIR COM A APLICAÇÃO
    // DEPOIS QUE USO A ANOTAÇÃO "POSTCONSTRUCT" DEVO COMENTALA PARA NÃO GERAR MAIS REGISTROS AO SUBIR O PROJETO
    //@PostConstruct
    public void savePost(){
        List<Post> postList = new ArrayList<>();

        Post postagem1 = new Post();

        postagem1.setTitle("Clean Code");
        postagem1.setAuthor("Robert Cecil Martin");
        postagem1.setPostDate(LocalDate.now());
        postagem1.setContent(
                        "Mesmo um código ruim pode funcionar. Mas se ele não for limpo, pode acabar "        +
                        "com uma empresa de desenvolvimento. Perdem-se a cada ano horas incontáveis "        +
                        "e recursos importantes devido a um código mal escrito. Mas não precisa ser assim. " +
                        "O renomado especialista em software");



        Post postagem2 = new Post();
        postagem2.setTitle("Design Patterns");
        postagem2.setAuthor("Erich Gamma");
        postagem2.setPostDate(LocalDate.now());
        postagem2.setContent(

                        "Padrões de Design: Elementos de Software Orientado a Objetos Reutilizáveis"    +
                        "é um livro de engenharia de software que descreve padrões de design de "       +
                        "software. O livro foi escrito por Erich Gamma, Richard Helm, Ralph Johnson "   +
                        "e John Vlissides, com prefácio de Grady Booch.");


        postList.add(postagem1);
        postList.add(postagem2);

        for (Post post : postList){
            Post postSaved = postRepository.save(post);
            System.out.println(postSaved.getId());
        }

    }
}
