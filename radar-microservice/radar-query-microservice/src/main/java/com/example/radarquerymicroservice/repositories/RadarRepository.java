package com.example.radarquerymicroservice.repositories;

import com.example.radarquerymicroservice.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {

}
