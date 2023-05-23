package com.example.movie_rental.ports.movie;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.models.Genre;

import java.math.BigDecimal;
import java.util.List;

public interface UpdateMovieCommand {
    Long id();
    String name();
    String rating();
    String description();
    Integer releaseYear();
    BigDecimal rentalRate();
    BigDecimal replacementCost();
    Genre genre();
    List<Actor> actors();
}
