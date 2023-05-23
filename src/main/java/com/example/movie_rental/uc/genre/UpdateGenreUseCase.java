package com.example.movie_rental.uc.genre;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.models.Genre;
import com.example.movie_rental.ports.actor.ActorReader;
import com.example.movie_rental.ports.actor.ActorUpdater;
import com.example.movie_rental.ports.genre.GenreReader;
import com.example.movie_rental.ports.genre.GenreUpdater;
import com.example.movie_rental.ports.genre.UpdateGenreCommand;
import com.example.movie_rental.web.actors.UpdateActorCommand;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class UpdateGenreUseCase {

    GenreUpdater updater;
    GenreReader reader;

    public UpdateGenreUseCase(GenreUpdater updater, GenreReader reader) {
        this.updater = updater;
        this.reader = reader;
    }

    public Optional<Genre> update(UpdateGenreCommand command) {
        var optionalGenre = this.reader.findOne(command.id());
        if (optionalGenre.isPresent()) {
            var genre = optionalGenre.get();
            genre.setName(command.name());
            genre.setUpdatedAt(Date.from(Instant.now()));
            return Optional.ofNullable(this.updater.update(genre));
        }
        return Optional.empty();
    }
}
