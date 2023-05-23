package com.example.movie_rental.web.actors;

public record UpdateActorCommand(Long id, String firstName, String lastName) implements com.example.movie_rental.ports.actor.UpdateActorCommand {
}
