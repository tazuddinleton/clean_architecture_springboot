package com.example.movie_rental.usecases;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.ports.ActorCreator;
import com.example.movie_rental.ports.CreateActorRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

@Service
public class CreateActor {
    ActorCreator actorCreator;

    public CreateActor(ActorCreator creator) {
        this.actorCreator = creator;
    }

    public Actor createActor(CreateActorRequest request) {
        var actor = Actor.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .createdAt(Date.from(Instant.now()))
                .build();
        return actorCreator.create(actor);
    }
}
