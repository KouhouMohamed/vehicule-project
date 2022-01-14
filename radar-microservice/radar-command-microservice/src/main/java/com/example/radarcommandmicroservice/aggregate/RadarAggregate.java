package com.example.radarcommandmicroservice.aggregate;

import commands.RadarCreateCommand;
import commands.RadarUpdateCommand;
import events.RadarCreatedEvent;
import events.RadarUpdatedEvent;
import exceptions.NegativeVitesseException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class RadarAggregate {

    @AggregateIdentifier
    private String radarId;
    private int vitesse;
    private double latitude;
    private double longitude;

    public RadarAggregate(){}

    @CommandHandler
    public RadarAggregate(RadarCreateCommand command){
        log.info("RadarCreateCommand Occurred");
        if (command.getVitesse_max() <= 0) throw new NegativeVitesseException("La vitesse du radar ne doit pas etre négative ou nulle");
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getVitesse_max(),
                command.getLatitude(),
                command.getLongitude(),
                command.getDate()
        ));
    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        log.info("RadarCreatedEvent Occurred");
        this.radarId = event.getId();
        this.vitesse = event.getVitesse();
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();
    }

    @CommandHandler
    public void handle(RadarUpdateCommand command){
        if (command.getNewVitesse_max() <= 0) throw new NegativeVitesseException("La vitesse du radar ne doit pas etre négative ou nulle");
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getNewVitesse_max(),
                command.getNewLatitude(),
                command.getNewLongitude(),
                command.getDate()
        ));
    }

    @EventSourcingHandler
    public void on(RadarUpdatedEvent event){
        log.info("RadarCreatedEvent Occurred");
        this.radarId = event.getId();
        this.vitesse = event.getNewVitesse();
        this.latitude = event.getNewLatitude();
        this.longitude = event.getNewLongitude();
    }
}
