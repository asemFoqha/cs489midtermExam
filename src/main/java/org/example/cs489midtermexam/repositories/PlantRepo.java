package org.example.cs489midtermexam.repositories;

import org.example.cs489midtermexam.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepo extends JpaRepository<Plant, Integer> {
    Optional<Plant> findByPlantName(String name);
}
