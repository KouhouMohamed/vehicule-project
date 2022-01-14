package com.example.radarcommandmicroservice.controller;

import com.example.radarcommandmicroservice.service.RadarService;
import dtos.RadarRequestDto;
import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/radar")
@AllArgsConstructor
public class RadarController {
    private RadarService radarService;
    private EventStore eventStore;

    @PostMapping(path = "/create")
    public CompletableFuture<String> createRadar(@RequestBody RadarRequestDto request){
        CompletableFuture<String> response = radarService.createRadar(request);
        return response;
    }

    @PostMapping(path = "/update/{idRadar}")
    public CompletableFuture<String> updateRadar(@PathVariable String idRadar, @RequestBody RadarRequestDto request){
        CompletableFuture<String> response = radarService.updateRadar(idRadar,request);
        return response;
    }
}
