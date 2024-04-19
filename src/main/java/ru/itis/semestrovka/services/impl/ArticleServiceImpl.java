package ru.itis.semestrovka.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.semestrovka.dto.ArticleDto;
import ru.itis.semestrovka.dto.ArticlesPage;
import ru.itis.semestrovka.exceptions.NotFoundException;
import ru.itis.semestrovka.models.Article;
import ru.itis.semestrovka.repositories.ArticleRepository;
import ru.itis.semestrovka.services.ArticleService;

import static ru.itis.semestrovka.dto.ArticleDto.of;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Value("${default.page-size}")
    private int defaultPageSize;

    @Override
    public ArticlesPage getAllArticles(int page) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<Article> articlePage = articleRepository.findAll(pageRequest);
        return ArticlesPage.builder()
                .articles(of(articlePage.getContent()))
                .totalPagesCount(articlePage.getTotalPages())
                .build();
    }

//    @Override
//    public ArticleDto addArticle(NewOrUpdatedArticleDto newOrUpdatedArticleDto) {
//        String emailOfNewOrUpdatedUser = newOrUpdateUserDto.getEmail();
//        userRepository.findByEmail(emailOfNewOrUpdatedUser).orElseThrow((()
//                -> new DuplicateEntityException("Пользователь с email: <" + newOrUpdateUserDto.getEmail() + "> уже существует")));
//        Article article = Article.builder()
//                .name(newOrUpdatedArticleDto.getName())
//                .content(newOrUpdatedArticleDto.getContent())
//                .build();
//        articleRepository.save(article);
//        return from(article);
//    }

    @Override
    public ArticleDto getArticle(Long articleId) {
        return of(getArticleOrThrow(articleId));
    }

//    @Override
//    public ArticleDto updateArticle(Long articleId, NewOrUpdatedArticleDto updatedArticle) {
//        return null;
//    }

    @Override
    public void deleteArticle(Long articleId) {
        Article articleForDelete = getArticleOrThrow(articleId);
        articleRepository.deleteById(articleId);
    }

    private Article getArticleOrThrow(Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow((() -> new NotFoundException("Статья с идентификатором <" + articleId + "> не найдена")));
    }
}
