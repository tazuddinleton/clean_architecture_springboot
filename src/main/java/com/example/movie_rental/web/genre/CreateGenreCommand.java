package com.example.movie_rental.web.genre;

public record CreateGenreCommand(String name) implements com.example.movie_rental.ports.genre.CreateGenreCommand {
}

