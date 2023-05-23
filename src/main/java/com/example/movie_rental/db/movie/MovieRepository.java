package com.example.movie_rental.db.movie;


import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MoviePersistenceModel, Long> {}
