package com.example.movie_rental.ports.movie;

import com.example.movie_rental.models.Movie;

public interface MovieUpdater {
    Movie update(Movie movie);
}
