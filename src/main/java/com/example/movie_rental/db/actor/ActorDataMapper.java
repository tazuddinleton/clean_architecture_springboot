package com.example.movie_rental.db.actor;
import com.example.movie_rental.models.Actor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ActorDataMapper {
    public ActorPersistenceModel toPersistenceModel(Actor actor) {
        return ActorPersistenceModel
                .builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .createdAt(actor.getCreatedAt())
                .updatedAt(actor.getUpdatedAt())
                .build();
    }

    public Actor toDomainModel(ActorPersistenceModel model) {
        return Actor.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .build();
    }

    public Optional<Actor> toOptionalDomainModel(ActorPersistenceModel model) {
        return Optional.ofNullable(this.toDomainModel(model));
    }

    public List<Actor> toDomainModels(Iterable<ActorPersistenceModel> models) {
        return StreamSupport
                .stream(models.spliterator(), true)
                .map(this::toDomainModel)
                .collect(Collectors.toList());
    }
}
