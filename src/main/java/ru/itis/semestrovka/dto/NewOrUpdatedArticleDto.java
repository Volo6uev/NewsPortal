package ru.itis.semestrovka.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewOrUpdatedArticleDto {

    @NotBlank(message = "{newArticle.image.blank}")
    private String image;

    @NotBlank(message = "{newArticle.name.blank}")
    @Size(min = 3,max = 150,message = "{newArticle.name.size}")
    private String name;

    @NotBlank(message = "{newArticle.content.blank}")
    @Size(min = 100,message = "{newArticle.content.size}")
    private String content;
}
