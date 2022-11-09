package com.springboot.mvcboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="article") // @table annotation?
@Getter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String content;


    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
