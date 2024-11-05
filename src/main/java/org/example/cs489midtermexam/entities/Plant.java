package org.example.cs489midtermexam.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer plantId;
    @Column(name = "plant_name")
    private String plantName;
    @Column(name = "plant_type")
    private String type;
    @Column(name = "plant_date")
    private LocalDate plantDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "garden_id")
    private Garden garden;

    public Plant(String plantName, String type, LocalDate plantDate, Garden garden) {
        this.plantName = plantName;
        this.type = type;
        this.plantDate = plantDate;
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "ID=" + plantId +
                ", Name='" + plantName + '\'' +
                ", Type='" + type + '\'' +
                ", Plant Date=" + plantDate +
                ", Garden=" + garden.getGardenName() +
                '}';
    }
}
