package com.example.movie_rental.adopters.actors;

import com.example.movie_rental.ports.CreateActorRequest;

public record CreateActorCommand(String firstName, String lastName) implements CreateActorRequest {
}
