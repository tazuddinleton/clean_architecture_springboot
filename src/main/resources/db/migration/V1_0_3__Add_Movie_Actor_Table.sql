CREATE TABLE IF NOT EXISTS movie_rental.movie_actor (
    movie_id int not null,
    actor_id int not null,

    CONSTRAINT fk_movies FOREIGN KEY(movie_id) REFERENCES movie_rental.movies(id),
    CONSTRAINT fk_actor FOREIGN KEY(actor_id) REFERENCES movie_rental.actors(id)
)