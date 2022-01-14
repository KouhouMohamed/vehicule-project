package com.example.immatriculequerymicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    private String id;
    private String matricule;
    private String marque;
    private int puissance_fiscale;
    private String modele;
}
