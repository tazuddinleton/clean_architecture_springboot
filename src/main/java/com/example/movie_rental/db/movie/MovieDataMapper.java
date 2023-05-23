package com.example.movie_rental.db.movie;

import com.example.movie_rental.db.actor.ActorDataMapper;
import com.example.movie_rental.db.genre.GenreDataMapper;
import com.example.movie_rental.models.Genre;
import com.example.movie_rental.models.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MovieDataMapper {
    GenreDataMapper genreDataMapper;
    ActorDataMapper actorDataMapper;

    public MovieDataMapper(GenreDataMapper genreDataMapper, ActorDataMapper actorDataMapper) {
        this.genreDataMapper = genreDataMapper;
        this.actorDataMapper = actorDataMapper;
    }

    public MoviePersistenceModel toPersistenceModel(Movie movie) {
        return MoviePersistenceModel
                .builder()
                .id(movie.getId())
                .name(movie.getName())
                .rating(movie.getRating())
                .createdAt(movie.getCreatedAt())
                .updatedAt(movie.getUpdatedAt())
                .rentalRate(movie.getRentalRate())
                .releaseYear(movie.getReleaseYear())
                .description(movie.getDescription())
                .replacementCost(movie.getReplacementCost())
                .genre(this.genreDataMapper.toPersistenceModel(movie.getGenre()))
                .actors(this.actorDataMapper.toPersistenceModel(movie.getActors()))
                .build();
    }

    public Movie toDomainModel(MoviePersistenceModel model) {
        return Movie.builder()
                .id(model.getId())
                .name(model.getName())
                .rating(model.getRating())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .rentalRate(model.getRentalRate())
                .releaseYear(model.getReleaseYear())
                .description(model.getDescription())
                .replacementCost(model.getReplacementCost())
                .genre(this.genreDataMapper.toDomainModel(model.getGenre()))
                .actors(this.actorDataMapper.toDomainModels(model.getActors()))
                .build();
    }

    public Optional<Movie> toOptionalDomainModel(MoviePersistenceModel model) {
        return Optional.ofNullable(this.toDomainModel(model));
    }

    public List<Movie> toDomainModels(Iterable<MoviePersistenceModel> models) {
        return StreamSupport
                .stream(models.spliterator(), true)
                .map(this::toDomainModel)
                .collect(Collectors.toList());
    }
}
