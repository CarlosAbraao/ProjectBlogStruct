package com.carlosdev.blogStruct.StructBlogdev.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // TITULO E AUTOR NÃO PODEM FICAR EM BRANCO
    @NotBlank
    private String title;
    @NotBlank
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-YYYY")
    private LocalDate postDate;

    @NotBlank
    @Lob // PARA QUE O BANCO SAIBA QUE O TEXTO PODE CHEGAR A SER GRANDE E MELHORE A PERFORMANCE
    private String content;

}
