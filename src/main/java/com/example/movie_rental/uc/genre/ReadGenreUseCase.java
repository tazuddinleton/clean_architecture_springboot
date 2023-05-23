package com.example.movie_rental.uc.genre;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.models.Genre;
import com.example.movie_rental.ports.actor.ActorReader;
import com.example.movie_rental.ports.genre.GenreReader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadGenreUseCase {
    GenreReader reader;
    public ReadGenreUseCase(GenreReader reader) {
        this.reader = reader;
    }

    public List<Genre> readAll() {
        return this.reader.readAll();
    }
}
