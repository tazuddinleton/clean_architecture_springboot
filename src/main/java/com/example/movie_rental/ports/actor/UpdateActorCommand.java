package com.example.movie_rental.ports.actor;

public interface UpdateActorCommand {
    Long id();
    String firstName();

    String lastName();
}
