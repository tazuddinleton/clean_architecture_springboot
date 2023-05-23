package com.example.movie_rental.ports.genre;

import com.example.movie_rental.models.Genre;

public interface GenreCreator {
    Genre create(Genre genre);
}
