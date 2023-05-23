package com.example.movie_rental.uc.movie;

import com.example.movie_rental.models.Genre;
import com.example.movie_rental.models.Movie;
import com.example.movie_rental.ports.genre.GenreReader;
import com.example.movie_rental.ports.movie.MovieReader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadMovieUseCase {
    MovieReader reader;
    public ReadMovieUseCase(MovieReader reader) {
        this.reader = reader;
    }

    public List<Movie> readAll() {
        return this.reader.readAll();
    }
}
