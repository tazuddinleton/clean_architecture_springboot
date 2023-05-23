package com.example.movie_rental.db.genre;


import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<GenrePersistenceModel, Long> {}
