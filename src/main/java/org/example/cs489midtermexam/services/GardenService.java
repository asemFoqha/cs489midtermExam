package org.example.cs489midtermexam.services;

import org.example.cs489midtermexam.entities.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GardenService {
    Optional<Garden> addGarden(Garden garden);
    Optional<Garden> getGardenByName(String gardenName);
    List<Garden> getAllGardens();
    Optional<Garden> updateGarden(Garden garden);
    void deleteGardenByName(String gardenName);

}
