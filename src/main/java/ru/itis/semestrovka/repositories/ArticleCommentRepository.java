package ru.itis.semestrovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.semestrovka.models.ArticleComment;

@Repository
public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long> {
}
