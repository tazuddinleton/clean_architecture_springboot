package com.example.movie_rental.web.actors;

import com.example.movie_rental.ports.actor.UpdateActorRequest;

public record UpdateActorCommand(Long id, String firstName, String lastName) implements UpdateActorRequest {
}
