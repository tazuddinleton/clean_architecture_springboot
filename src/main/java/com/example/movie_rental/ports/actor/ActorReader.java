package com.example.movie_rental.ports.actor;

import com.example.movie_rental.models.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorReader {
    List<Actor> readAll();
    Optional<Actor> findOne(Long id);
}
