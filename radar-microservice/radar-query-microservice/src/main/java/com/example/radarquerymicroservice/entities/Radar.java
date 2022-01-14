package com.example.radarquerymicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private int vitesse_max;
    private double latitude;
    private double longitude;
}
