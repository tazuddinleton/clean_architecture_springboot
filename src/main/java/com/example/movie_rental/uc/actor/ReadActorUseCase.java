package com.example.movie_rental.uc.actor;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.ports.actor.ActorReader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadActorUseCase {
    ActorReader reader;
    public ReadActorUseCase(ActorReader reader) {
        this.reader = reader;
    }

    public List<Actor> readAll() {
        return this.reader.readAll();
    }
}
