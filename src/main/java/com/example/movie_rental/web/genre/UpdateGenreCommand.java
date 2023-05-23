package com.example.movie_rental.web.genre;

public record UpdateGenreCommand(Long id, String name) implements com.example.movie_rental.ports.genre.UpdateGenreCommand {
}
