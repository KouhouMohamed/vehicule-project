package com.example.immatriculequerymicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Proprietaire {
    @Id
    private String id;
    private String nom;
    private String email;
    private Date date_naissance;
}
