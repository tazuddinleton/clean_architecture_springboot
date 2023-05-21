package com.example.movie_rental.db.actor;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.ports.actor.ActorCreator;
import com.example.movie_rental.ports.actor.ActorUpdater;
import com.example.movie_rental.ports.actor.ActorReader;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ActorPersistenceAdopter implements ActorCreator, ActorUpdater, ActorReader {
    ActorRepository repository;
    ActorDataMapper mapper;

    public ActorPersistenceAdopter(ActorRepository repository, ActorDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Actor create(Actor actor) {
        var model = mapper.toPersistenceModel(actor);
        var savedModel = this.repository.save(model);
        return this.mapper.toDomainModel(savedModel);
    }

    @Override
    public List<Actor> readAll() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), true)
                .map(m -> this.mapper.toDomainModel(m))
                .sorted(Comparator.comparingLong(Actor::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Actor> findOne(Long id) {
        var optionalActor = this.repository.findById(id);
        return optionalActor.flatMap(m -> this.mapper.toOptionalDomainModel(m));
    }

    @Override
    public Actor update(Actor actor) {
        var updated = this.repository.save(this.mapper.toPersistenceModel(actor));
        return this.mapper.toDomainModel(updated);
    }
}
