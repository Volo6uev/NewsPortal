package ru.itis.semestrovka.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Length;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String name;

    private LocalDate dateOfPublishing;

    private String author;

//    @Lob
//    @JdbcTypeCode(SqlTypes.BLOB)
//    @Column(columnDefinition="text")
//    @Type(type = "org.hibernate.type.TextType")
    @Column(length= Length.LONG32)
    private String content;

    @OneToMany(mappedBy = "article")
    private List<ArticleComment> comments;

    private Integer likeCount;
    private Integer dislikeCount;
}
