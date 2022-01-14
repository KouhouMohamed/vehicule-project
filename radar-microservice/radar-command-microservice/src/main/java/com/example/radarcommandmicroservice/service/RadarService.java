package com.example.radarcommandmicroservice.service;

import commands.RadarCreateCommand;
import commands.RadarUpdateCommand;
import dtos.RadarRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class RadarService {
    private CommandGateway commandGateway;

    public CompletableFuture<String> createRadar(RadarRequestDto request){
        CompletableFuture<String> response = commandGateway.send(new RadarCreateCommand(
                UUID.randomUUID().toString(),
                request.getVitess(),
                request.getLatitude(),
                request.getLongitude(),
                new Date()
        ));
        return response;
    }

    public CompletableFuture<String> updateRadar(String idRadar, RadarRequestDto request) {

        CompletableFuture<String> response = commandGateway.send(new RadarUpdateCommand(
                idRadar,
                request.getVitess(),
                request.getLatitude(),
                request.getLongitude(),
                new Date()
        ));
        return response;
    }
}
