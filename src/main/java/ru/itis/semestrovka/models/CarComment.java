package ru.itis.semestrovka.models;

import jakarta.persistence.*;

@Entity
public class CarComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String author;

    @ManyToOne
//    @JoinColumn(name="car_id", nullable=false)
    private Car car;

    @Lob
    private String content;

    private Integer likeCount;
    private Integer dislikeCount;
}
