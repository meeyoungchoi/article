package com.example.article.form;

import com.example.article.vo.Article;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class ArticleForm {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }


}
