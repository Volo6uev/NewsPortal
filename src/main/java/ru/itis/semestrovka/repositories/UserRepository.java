package ru.itis.semestrovka.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.semestrovka.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAllByStateOrderById(Pageable pageable, User.State state);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndHashPassword(String email, String hashPassword);
}
