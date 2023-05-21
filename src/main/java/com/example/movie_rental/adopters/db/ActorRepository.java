package com.example.movie_rental.adopters.db;


import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<ActorPersistenceModel, Long> {}
