package ru.itis.semestrovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.semestrovka.models.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
