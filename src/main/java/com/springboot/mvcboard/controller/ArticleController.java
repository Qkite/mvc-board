package com.springboot.mvcboard.controller;


import com.springboot.mvcboard.domain.Article;
import com.springboot.mvcboard.dto.ArticleDto;
import com.springboot.mvcboard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    // Constructor를 이용해서 ArticleRepository와  ArticleController의 의존관계를 주입함(DI)
    // ArticleRepository: dao 클래스처럼 데이터를 생성하고 찾는 기능을 모두 담당함

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String createPage(){
        return "new";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
       Optional<Article> articleOptional= articleRepository.findById(id);
       if(!articleOptional.isEmpty()){
           model.addAttribute("article", articleOptional.get());
           return "show";
       } else{
           return "error";
       }
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Article> modelList = articleRepository.findAll();
        model.addAttribute("articles", modelList);
        return "list";
    }

    @GetMapping(value = "")
    public String firstDisplay(){
        return "redirect:/articles/list";
    }



    @PostMapping(value = "")
    public String add(ArticleDto articleDto){
        log.info(articleDto.getTitle(), articleDto.getContent());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generated:{}", savedArticle.getId());
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }

}
