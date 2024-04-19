package ru.itis.semestrovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.semestrovka.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
