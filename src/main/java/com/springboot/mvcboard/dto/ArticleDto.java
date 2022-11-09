package com.springboot.mvcboard.dto;

import com.springboot.mvcboard.domain.Article;
import lombok.Getter;

@Getter
public class ArticleDto {

    private Long id;
    private String title;
    private String content;


    public ArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity(){

        return new Article(this.title, this.content);
    }
}
