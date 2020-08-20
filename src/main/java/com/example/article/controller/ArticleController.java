package com.example.article.controller;

import com.example.article.form.ArticleForm;
import com.example.article.repository.ArticleRepository;
import com.example.article.vo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/article/new")
    public String newArticle() {
        return "articles/new";
    }

    @PostMapping("/article/new")
    public String create(ArticleForm articleForm) {
        log.info(articleForm.toString());

        Article article = articleForm.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "articles/index";
    }

    @GetMapping("/article/show/{id}")
    public String show(@PathVariable Long id, Model model) {
         Article article = articleRepository.findById(id).orElse(null);
         log.info(article.toString());
         model.addAttribute("article", article);
        return "articles/show";
    }

    @GetMapping("/article/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        log.info(article.toString());
        model.addAttribute("article", article);
        return "articles/edit";
    }

    @PostMapping("/article/update/{id}")
    public String update(ArticleForm articleForm) {
        log.info(articleForm.toString());

        Article article = articleForm.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/article/show/{id}";
    }

    @GetMapping("/article/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleRepository.deleteById(id);
        log.info(id + "번글 삭제");
        return "redirect:/";
    }
}
