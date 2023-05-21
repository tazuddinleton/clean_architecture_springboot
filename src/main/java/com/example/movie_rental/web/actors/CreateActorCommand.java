package com.example.movie_rental.web.actors;

import com.example.movie_rental.ports.actor.CreateActorRequest;

public record CreateActorCommand(String firstName, String lastName) implements CreateActorRequest {
}

