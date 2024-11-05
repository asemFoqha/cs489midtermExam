package org.example.cs489midtermexam.services;

import org.example.cs489midtermexam.entities.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantService {

    Optional<Plant> addPlant(Plant plant);
    Optional<Plant> getPlantByName(String plantName);
    List<Plant> getAllPlants();
    Optional<Plant> updatePlant(Plant plant);
    void deletePlantByName(String plantName);
}
