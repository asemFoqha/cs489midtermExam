package org.example.cs489midtermexam;

import lombok.RequiredArgsConstructor;


import org.example.cs489midtermexam.entities.Garden;
import org.example.cs489midtermexam.entities.Plant;
import org.example.cs489midtermexam.services.GardenService;
import org.example.cs489midtermexam.services.PlantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import java.util.Comparator;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Cs489midtermExamApplication {

    private final GardenService gardenService;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(Cs489midtermExamApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {


            Garden garden1 = new Garden("Vegetable Patch", 50.0);
            Garden garden2 = new Garden("Herb Garden", 20.0);

            gardenService.addGarden(garden1);
            gardenService.addGarden(garden2);

            Plant plant = new Plant("Tomato", "Vegetable", LocalDate.parse("2024-03-10"), garden1);
            Plant plant2 = new Plant("Carrot", "Vegetable", LocalDate.parse("2024-02-20"), garden1);
            Plant plant3 = new Plant("Basil", "Herb", LocalDate.parse("2024-04-05"), garden2);

            plantService.addPlant(plant);
            plantService.addPlant(plant2);
            plantService.addPlant(plant3);

            System.out.println("Gardens");
            System.out.println(garden1);
            System.out.println(garden2);
            System.out.println("Plants Sorted By Name");
            printPlantsSortedByName(List.of(plant, plant2, plant3));
            System.out.println("Plants Sorted By PlantDate");
            printPlantsSortedPlantDate(List.of(plant, plant2, plant3));


        };
    }

    public static void printPlantsSortedByName(List<Plant> plants) {

        plants.stream()
                .sorted(Comparator.comparing(Plant::getPlantName))
                .forEach(System.out::println);
    }

    public static void printPlantsSortedPlantDate(List<Plant> plants) {

        plants.stream()
                .sorted(Comparator.comparing(Plant::getPlantDate))
                .forEach(System.out::println);
    }


}
