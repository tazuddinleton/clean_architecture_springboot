package com.example.movie_rental.ports.genre;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.models.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreReader {
    List<Genre> readAll();
    Optional<Genre> findOne(Long id);
}
