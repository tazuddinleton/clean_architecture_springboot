package com.example.movie_rental.db.genre;

import com.example.movie_rental.models.Genre;
import com.example.movie_rental.ports.genre.GenreCreator;
import com.example.movie_rental.ports.genre.GenreReader;
import com.example.movie_rental.ports.genre.GenreUpdater;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GenrePersistenceAdopter implements GenreCreator, GenreUpdater, GenreReader {
    GenreRepository repository;
    GenreDataMapper mapper;

    public GenrePersistenceAdopter(GenreRepository repository, GenreDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Genre create(Genre genre) {
        var model = mapper.toPersistenceModel(genre);
        var savedModel = this.repository.save(model);
        return this.mapper.toDomainModel(savedModel);
    }

    @Override
    public List<Genre> readAll() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), true)
                .map(m -> this.mapper.toDomainModel(m))
                .sorted(Comparator.comparingLong(Genre::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Genre> findOne(Long id) {
        var optionalActor = this.repository.findById(id);
        return optionalActor.flatMap(m -> this.mapper.toOptionalDomainModel(m));
    }

    @Override
    public Genre update(Genre genre) {
        var updated = this.repository.save(this.mapper.toPersistenceModel(genre));
        return this.mapper.toDomainModel(updated);
    }
}
