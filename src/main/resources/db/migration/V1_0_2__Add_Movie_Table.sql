
CREATE TABLE IF NOT EXISTS movie_rental.movies (
    id serial PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    description VARCHAR(512) NOT NULL,
    rating VARCHAR(20) NOT NULL,
    release_year INT NOT NULL,
    rental_rate DECIMAL NOT NULL,
    replacement_cost DECIMAL NOT NULL,
    genre_id INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL,
    CONSTRAINT fk_genre FOREIGN KEY(genre_id) REFERENCES movie_rental.genre(id)
)

