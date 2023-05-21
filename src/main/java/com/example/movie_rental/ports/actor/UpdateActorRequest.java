package com.example.movie_rental.ports.actor;

public interface UpdateActorRequest {
    Long id();
    String firstName();

    String lastName();
}
