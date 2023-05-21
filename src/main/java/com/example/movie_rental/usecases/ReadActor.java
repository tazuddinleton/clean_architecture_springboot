package com.example.movie_rental.usecases;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.ports.actor.ActorReader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadActor {
    ActorReader reader;
    public ReadActor(ActorReader reader) {
        this.reader = reader;
    }

    public List<Actor> readAll() {
        return this.reader.readAll();
    }
}
