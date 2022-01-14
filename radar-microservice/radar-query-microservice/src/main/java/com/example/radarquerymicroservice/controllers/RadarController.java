package com.example.radarquerymicroservice.controllers;

import com.example.radarquerymicroservice.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import queries.GetAllRadarsQuery;
import queries.GetRadarQuery;

import java.util.List;

public class RadarController {
    QueryGateway queryGateway;

    @GetMapping(path = "/all", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public List<Radar> getAllRadars(){
        return queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class)).join();
    }

    @GetMapping(path = "/get/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public Radar getRadar(@PathVariable String id){
        return queryGateway.query(new GetRadarQuery(id), ResponseTypes.instanceOf(Radar.class)).join();
    }
}
