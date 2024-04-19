package ru.itis.semestrovka.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String name;

    @ManyToOne
//    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy = "car")
    private List<CarComment> comments;

    private Integer likeCount;
    private Integer dislikeCount;
}
