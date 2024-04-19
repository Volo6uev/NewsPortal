package ru.itis.semestrovka.models;

import jakarta.persistence.*;

@Entity
public class ArticleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String author;

    @ManyToOne
//    @JoinColumn(name="article_id", nullable=false)
    private Article article;

    @Lob
    private String content;

    private Integer likeCount;
    private Integer dislikeCount;
}
