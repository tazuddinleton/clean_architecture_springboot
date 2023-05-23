package com.example.movie_rental.web.movies;

import com.example.movie_rental.models.Genre;
import com.example.movie_rental.models.Movie;
import com.example.movie_rental.uc.genre.CreateGenreUseCase;
import com.example.movie_rental.uc.genre.ReadGenreUseCase;
import com.example.movie_rental.uc.genre.UpdateGenreUseCase;
import com.example.movie_rental.uc.movie.CreateMovieUseCase;
import com.example.movie_rental.uc.movie.ReadMovieUseCase;
import com.example.movie_rental.uc.movie.UpdateMovieUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    CreateMovieUseCase createMovieUseCase;
    UpdateMovieUseCase updateMovieUseCase;
    ReadMovieUseCase readMovieUseCase;

    public MoviesController(CreateMovieUseCase createMovieUseCase, UpdateMovieUseCase updateMovieUseCase, ReadMovieUseCase readMovieUseCase) {
        this.createMovieUseCase = createMovieUseCase;
        this.updateMovieUseCase = updateMovieUseCase;
        this.readMovieUseCase = readMovieUseCase;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody CreateMovieCommand command) {
        var movie = this.createMovieUseCase.createMovie(command);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> readGenre() {
        return new ResponseEntity<>(this.readMovieUseCase.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Movie> updateGenre(@RequestBody UpdateMovieCommand command) {
        var optional = this.updateMovieUseCase.update(command);
        return optional
                .map(movie -> new ResponseEntity<>(movie, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
