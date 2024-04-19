package ru.itis.semestrovka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.semestrovka.models.Article;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {

    private Long id;

    private String image;

    private String name;

    private LocalDate dateOfPublishing;

    private String author;

    private String content;

    public static ArticleDto of(Article article){
        return ArticleDto.builder()
                .id(article.getId())
                .image(article.getImage())
                .name(article.getName())
                .dateOfPublishing(article.getDateOfPublishing())
                .author(article.getAuthor())
                .content(article.getContent())
                .build();
    }

    public static List<ArticleDto> of(List<Article> articles) {
        return articles.stream().map(ArticleDto::of).collect(Collectors.toList());
    }
}
