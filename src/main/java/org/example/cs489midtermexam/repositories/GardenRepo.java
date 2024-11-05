package org.example.cs489midtermexam.repositories;

import org.example.cs489midtermexam.entities.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GardenRepo extends JpaRepository<Garden, Integer> {

    Optional<Garden> findByGardenName(String name);
}
