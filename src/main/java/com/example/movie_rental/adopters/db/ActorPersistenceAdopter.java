package com.example.movie_rental.adopters.db;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.ports.ActorCreator;
import com.example.movie_rental.ports.ActorUpdater;
import com.example.movie_rental.ports.ActorReader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return null;
    }

    @Override
    public Optional<Actor> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Actor update(Actor actor) {
        return null;
    }
}
