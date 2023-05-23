package com.example.movie_rental.uc.genre;

import com.example.movie_rental.models.Genre;
import com.example.movie_rental.ports.genre.CreateGenreCommand;
import com.example.movie_rental.ports.genre.GenreCreator;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CreateGenreUseCase {
    GenreCreator genreCreator;


    public CreateGenreUseCase(GenreCreator creator) {
        this.genreCreator = creator;
    }

    public Genre createGenre(CreateGenreCommand request) {
        var genre = Genre.builder()
                .name(request.name())
                .createdAt(Timestamp.from(Instant.now()))
                .build();
        return this.genreCreator.create(genre);
    }
}
