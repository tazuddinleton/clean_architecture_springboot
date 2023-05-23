package com.example.movie_rental.uc.actor;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.ports.actor.ActorCreator;
import com.example.movie_rental.ports.actor.CreateActorCommand;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

@Service
public class CreateActorUseCase {
    ActorCreator actorCreator;

    public CreateActorUseCase(ActorCreator creator) {
        this.actorCreator = creator;
    }

    public Actor createActor(CreateActorCommand request) {
        var actor = Actor.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .createdAt(Date.from(Instant.now()))
                .build();
        return actorCreator.create(actor);
    }
}
