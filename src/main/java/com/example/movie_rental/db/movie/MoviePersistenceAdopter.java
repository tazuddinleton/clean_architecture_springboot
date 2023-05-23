package com.example.movie_rental.db.movie;

import com.example.movie_rental.models.Genre;
import com.example.movie_rental.models.Movie;
import com.example.movie_rental.ports.movie.MovieCreator;
import com.example.movie_rental.ports.movie.MovieReader;
import com.example.movie_rental.ports.movie.MovieUpdater;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MoviePersistenceAdopter implements MovieCreator, MovieUpdater, MovieReader {
    MovieRepository repository;
    MovieDataMapper mapper;

    public MoviePersistenceAdopter(MovieRepository repository, MovieDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Movie create(Movie genre) {
        var model = mapper.toPersistenceModel(genre);
        var savedModel = this.repository.save(model);
        return this.mapper.toDomainModel(savedModel);
    }

    @Override
    public List<Movie> readAll() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), true)
                .map(m -> this.mapper.toDomainModel(m))
                .sorted(Comparator.comparingLong(Movie::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findOne(Long id) {
        var optionalActor = this.repository.findById(id);
        return optionalActor.flatMap(m -> this.mapper.toOptionalDomainModel(m));
    }

    @Override
    public Movie update(Movie genre) {
        var updated = this.repository.save(this.mapper.toPersistenceModel(genre));
        return this.mapper.toDomainModel(updated);
    }
}
