package org.example.cs489midtermexam.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.cs489midtermexam.entities.Garden;
import org.example.cs489midtermexam.repositories.GardenRepo;
import org.example.cs489midtermexam.services.GardenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {

    private final GardenRepo gardenRepo;

    @Override
    public Optional<Garden> addGarden(Garden garden) {
        Garden savedGarden = gardenRepo.save(garden);
        return Optional.of(savedGarden);
    }

    @Override
    public Optional<Garden> getGardenByName(String gardenName) {
        return gardenRepo.findByGardenName(gardenName);
    }

    @Override
    public List<Garden> getAllGardens() {
        return gardenRepo.findAll();
    }

    @Override
    public Optional<Garden> updateGarden(Garden garden) {
        Optional<Garden> foundGarden = gardenRepo.findById(garden.getGardenId());
        if (foundGarden.isPresent()) {
            foundGarden.get().setGardenName(garden.getGardenName());
            foundGarden.get().setSize(garden.getSize());
            gardenRepo.save(foundGarden.get());
            return foundGarden;
        }
        return Optional.empty();
    }

    @Override
    public void deleteGardenByName(String gardenName) {
        Optional<Garden> foundGarden = gardenRepo.findByGardenName(gardenName);
        foundGarden.ifPresent(gardenRepo::delete);
    }
}
