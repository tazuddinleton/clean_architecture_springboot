package com.example.movie_rental.web.movies;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.models.Genre;

import java.math.BigDecimal;
import java.util.List;

public record CreateMovieCommand(
        String name,
        String rating,
        String description,
        Integer releaseYear,
        BigDecimal rentalRate,
        BigDecimal replacementCost,
        Genre genre,
        List<Actor> actors
) implements com.example.movie_rental.ports.movie.CreateMovieCommand {
}

