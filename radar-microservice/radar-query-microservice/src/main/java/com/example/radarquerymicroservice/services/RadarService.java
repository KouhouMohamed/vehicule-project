package com.example.radarquerymicroservice.services;

import com.example.radarquerymicroservice.entities.Radar;
import com.example.radarquerymicroservice.repositories.RadarRepository;
import events.RadarCreatedEvent;
import events.RadarUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.annotation.Persistent;
import queries.GetAllRadarsQuery;
import queries.GetRadarQuery;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Persistent
public class RadarService {
    private RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        log.info("Handle Account Created Event");
        // Create Account
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radar.setVitesse_max(event.getVitesse());

        radarRepository.save(radar);
    }

    @EventHandler
    public void on(RadarUpdatedEvent event){
        log.info("Handle Account Update Event");
        Radar radar = radarRepository.findById(event.getId()).get();
        if (radar == null) throw new EntityNotFoundException("No radar with the id "+event.getId()+" is found");

        else{
            radar.setVitesse_max(event.getNewVitesse());
            radar.setLatitude(event.getNewLatitude());
            radar.setLongitude(event.getNewLongitude());
            radarRepository.save(radar);
        }
    }

    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query){return radarRepository.findAll();}

    @QueryHandler
    public Radar on(GetRadarQuery query){return radarRepository.findById(query.getRadarId()).get();}
}
