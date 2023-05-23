package com.example.movie_rental.web.genre;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.models.Genre;
import com.example.movie_rental.uc.genre.CreateGenreUseCase;
import com.example.movie_rental.uc.genre.ReadGenreUseCase;
import com.example.movie_rental.uc.genre.UpdateGenreUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {


    CreateGenreUseCase createGenreUseCase;
    UpdateGenreUseCase updateGenreUseCase;
    ReadGenreUseCase readGenreUseCase;

    public GenreController(CreateGenreUseCase createGenreUseCase, UpdateGenreUseCase updateGenreUseCase, ReadGenreUseCase readGenreUseCase) {
        this.createGenreUseCase = createGenreUseCase;
        this.updateGenreUseCase = updateGenreUseCase;
        this.readGenreUseCase = readGenreUseCase;
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody CreateGenreCommand command) {
        var actor = this.createGenreUseCase.createGenre(command);
        return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Genre>> readGenre() {
        return new ResponseEntity<>(this.readGenreUseCase.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Genre> updateGenre(@RequestBody UpdateGenreCommand command) {
        var optional = this.updateGenreUseCase.update(command);
        return optional
                .map(actor -> new ResponseEntity<>(actor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
