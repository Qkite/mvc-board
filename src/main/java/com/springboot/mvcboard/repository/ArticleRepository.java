package com.springboot.mvcboard.repository;

import com.springboot.mvcboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
