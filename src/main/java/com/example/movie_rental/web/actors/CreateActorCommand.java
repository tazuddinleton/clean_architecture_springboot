package com.example.movie_rental.web.actors;

public record CreateActorCommand(String firstName, String lastName) implements com.example.movie_rental.ports.actor.CreateActorCommand {
}

