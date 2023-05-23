package com.example.movie_rental.uc.movie;

import com.example.movie_rental.models.Genre;
import com.example.movie_rental.models.Movie;
import com.example.movie_rental.ports.genre.CreateGenreCommand;
import com.example.movie_rental.ports.genre.GenreCreator;
import com.example.movie_rental.ports.movie.CreateMovieCommand;
import com.example.movie_rental.ports.movie.MovieCreator;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CreateMovieUseCase {
    MovieCreator movieCreator;

    public CreateMovieUseCase(MovieCreator movieCreator) {
        this.movieCreator = movieCreator;
    }

    public Movie createMovie(CreateMovieCommand command) {
        // Todo: Verify that genre and actors exists before trying to create movie
        var genre = Movie.builder()
                .name(command.name())
                .rating(command.rating())

                .rentalRate(command.rentalRate())
                .releaseYear(command.releaseYear())
                .description(command.description())
                .replacementCost(command.replacementCost())
                .genre(command.genre())
                .actors(command.actors())
                .createdAt(Timestamp.from(Instant.now()))
                .build();
        return this.movieCreator.create(genre);
    }
}
