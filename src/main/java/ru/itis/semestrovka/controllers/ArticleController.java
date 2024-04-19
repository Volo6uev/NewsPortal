package ru.itis.semestrovka.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.semestrovka.dto.ArticleDto;
import ru.itis.semestrovka.services.ArticleService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/articles")
    public String getAllArticles(int page, ModelMap model) {

        List<ArticleDto> allArticles = articleService.getAllArticles(page).getArticles();

        int pageCount = articleService.getAllArticles(page).getTotalPagesCount();

        model.addAttribute("articles",allArticles);
        System.out.println(allArticles);
        model.addAttribute("pageCount",pageCount);

        return "mainPage";
    }


//    public String addArticle(@Valid NewOrUpdateUserDto newOrUpdateUserDto) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.addUser(newOrUpdateUserDto));
//    }

    @GetMapping("/articles/{article-id}")
    public String getArticle(@PathVariable("article-id") Long articleId) {
        articleService.getArticle(articleId);
        return "articlePage";
    }

//    public String updateArticle(Long userId, @Valid NewOrUpdateUserDto updatedUser) {
//        return ResponseEntity.accepted().body(usersService.updateUser(userId, updatedUser));
//    }

//    public String deleteArticle(Long userId) {
//        usersService.deleteUser(userId);
//        return ResponseEntity.accepted().build();
//    }

}
