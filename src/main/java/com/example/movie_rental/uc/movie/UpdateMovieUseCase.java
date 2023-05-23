package com.example.movie_rental.uc.movie;

import com.example.movie_rental.models.Genre;
import com.example.movie_rental.models.Movie;
import com.example.movie_rental.ports.genre.GenreReader;
import com.example.movie_rental.ports.genre.GenreUpdater;
import com.example.movie_rental.ports.genre.UpdateGenreCommand;
import com.example.movie_rental.ports.movie.MovieReader;
import com.example.movie_rental.ports.movie.MovieUpdater;
import com.example.movie_rental.ports.movie.UpdateMovieCommand;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class UpdateMovieUseCase {

    MovieUpdater movieUpdater;
    MovieReader movieReader;

    public UpdateMovieUseCase(MovieUpdater movieUpdater, MovieReader movieReader) {
        this.movieUpdater = movieUpdater;
        this.movieReader = movieReader;
    }

    public Optional<Movie> update(UpdateMovieCommand command) {
        // Todo: Verify that actors and genre exists before updating the movie
        var optional = this.movieReader.findOne(command.id());
        if (optional.isPresent()) {
            var movie = optional.get();
            movie.setName(command.name());
            movie.setRating(command.rating());
            movie.setDescription(command.description());
            movie.setActors(command.actors());
            movie.setGenre(command.genre());
            movie.setReleaseYear(command.releaseYear());
            movie.setRentalRate(command.rentalRate());
            movie.setReplacementCost(command.replacementCost());
            movie.setUpdatedAt(Timestamp.from(Instant.now()));
            return Optional.ofNullable(this.movieUpdater.update(movie));
        }
        return Optional.empty();
    }
}
