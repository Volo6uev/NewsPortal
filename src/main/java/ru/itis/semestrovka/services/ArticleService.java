package ru.itis.semestrovka.services;

import ru.itis.semestrovka.dto.ArticleDto;
import ru.itis.semestrovka.dto.ArticlesPage;

public interface ArticleService {

    ArticlesPage getAllArticles(int page);

//    ArticleDto addArticle(NewOrUpdatedArticleDto newOrUpdatedArticleDto);

    ArticleDto getArticle(Long articleId);

//    ArticleDto updateArticle(Long articleId, NewOrUpdatedArticleDto updatedArticle);

    void deleteArticle(Long articleId);
}
