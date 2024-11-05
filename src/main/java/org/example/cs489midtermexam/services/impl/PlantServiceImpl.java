package org.example.cs489midtermexam.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.cs489midtermexam.entities.Plant;
import org.example.cs489midtermexam.repositories.PlantRepo;
import org.example.cs489midtermexam.services.PlantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepo plantRepo;

    @Override
    public Optional<Plant> addPlant(Plant plant) {
        Plant savedPlant = plantRepo.save(plant);
        return Optional.of(savedPlant);
    }

    @Override
    public Optional<Plant> getPlantByName(String plantName) {
        return plantRepo.findByPlantName(plantName);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepo.findAll();
    }

    @Override
    public Optional<Plant> updatePlant(Plant plant) {
        Optional<Plant> foundPlant = plantRepo.findById(plant.getPlantId());
        if (foundPlant.isPresent()) {
            foundPlant.get().setPlantName(plant.getPlantName());
            foundPlant.get().setPlantDate(plant.getPlantDate());
            foundPlant.get().setType(plant.getType());
            foundPlant.get().setGarden(plant.getGarden());
            plantRepo.save(foundPlant.get());
            return foundPlant;
        }
        return Optional.empty();
    }

    @Override
    public void deletePlantByName(String plantName) {
        Optional<Plant> foundPlant = plantRepo.findByPlantName(plantName);
        foundPlant.ifPresent(plantRepo::delete);
    }
}
