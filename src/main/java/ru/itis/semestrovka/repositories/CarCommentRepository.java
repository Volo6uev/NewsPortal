package ru.itis.semestrovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.semestrovka.models.CarComment;

@Repository
public interface CarCommentRepository extends JpaRepository<CarComment,Long> {
}
