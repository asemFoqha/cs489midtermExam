package org.example.cs489midtermexam.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "garden")
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer gardenId;
    @Column(name = "garden_name")
    private String gardenName;
    @Column(name = "garden_size")
    private Double size;

    @OneToMany(mappedBy = "garden")
    private List<Plant> plants;

    public Garden(Integer gardenId, String gardenName, Double size) {
        this.gardenId = gardenId;
        this.gardenName = gardenName;
        this.size = size;
        this.plants = plants;
    }

    public Garden(String gardenName, Double size) {
        this.gardenName = gardenName;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "ID=" + gardenId +
                ", Name='" + gardenName + '\'' +
                ", Size=" + size + "m^2"+
                '}';
    }
}
