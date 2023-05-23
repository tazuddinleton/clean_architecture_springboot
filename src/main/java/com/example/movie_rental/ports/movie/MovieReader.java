package com.example.movie_rental.ports.movie;

import com.example.movie_rental.models.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieReader {
    List<Movie> readAll();
    Optional<Movie> findOne(Long id);
}
