package com.example.movie_rental.usecases;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.ports.actor.ActorReader;
import com.example.movie_rental.ports.actor.ActorUpdater;
import com.example.movie_rental.web.actors.UpdateActorCommand;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class UpdateActor {

    ActorUpdater updater;
    ActorReader reader;

    public UpdateActor(ActorUpdater updater, ActorReader reader) {
        this.updater = updater;
        this.reader = reader;
    }

    public Optional<Actor> update(UpdateActorCommand command) {
        System.out.println("Received update command " + command.toString());
        var optionalActor = this.reader.findOne(command.id());
        if (optionalActor.isPresent()) {

            var actor = optionalActor.get();
            System.out.println("Updating " + actor.toString());
            actor.setFirstName(command.firstName());
            actor.setLastName(command.lastName());
            actor.setUpdatedAt(Date.from(Instant.now()));
            return Optional.ofNullable(this.updater.update(actor));
        }
        return Optional.empty();
    }
}
