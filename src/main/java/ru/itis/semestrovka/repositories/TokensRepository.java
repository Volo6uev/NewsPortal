package ru.itis.semestrovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.semestrovka.models.Token;

import java.util.Optional;

@Repository
public interface TokensRepository extends JpaRepository<Token, Long> {

    Optional<Token> findFirstByToken(String token);
}
