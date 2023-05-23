package com.example.movie_rental.db.genre;

import com.example.movie_rental.models.Genre;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class GenreDataMapper {
    public GenrePersistenceModel toPersistenceModel(Genre genre) {
        return GenrePersistenceModel
                .builder()
                .id(genre.getId())
                .name(genre.getName())
                .createdAt(genre.getCreatedAt())
                .updatedAt(genre.getUpdatedAt())
                .build();
    }

    public Genre toDomainModel(GenrePersistenceModel model) {
        return Genre.builder()
                .id(model.getId())
                .name(model.getName())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .build();
    }

    public Optional<Genre> toOptionalDomainModel(GenrePersistenceModel model) {
        return Optional.ofNullable(this.toDomainModel(model));
    }

    public List<Genre> toDomainModels(Iterable<GenrePersistenceModel> models) {
        return StreamSupport
                .stream(models.spliterator(), true)
                .map(this::toDomainModel)
                .collect(Collectors.toList());
    }
}
