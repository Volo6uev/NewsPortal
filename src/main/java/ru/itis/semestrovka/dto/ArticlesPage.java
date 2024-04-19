package ru.itis.semestrovka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticlesPage {

    private List<ArticleDto> articles;

    private Integer totalPagesCount;
}
