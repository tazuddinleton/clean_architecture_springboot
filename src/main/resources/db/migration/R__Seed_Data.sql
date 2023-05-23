-- Genre
INSERT INTO movie_rental.genre(name, created_at, updated_at)
VALUES ('Action', CURRENT_DATE, NULL);
INSERT INTO movie_rental.genre(name, created_at, updated_at)
VALUES ('Romantic', CURRENT_DATE, NULL);
INSERT INTO movie_rental.genre(name, created_at, updated_at)
VALUES ('Horror', CURRENT_DATE, NULL);
INSERT INTO movie_rental.genre(name, created_at, updated_at)
VALUES ('Sci-Fi', CURRENT_DATE, NULL);
-- Actors
INSERT INTO actors (first_name, last_name, created_at, updated_at)
VALUES ('Tom', 'Hanks', CURRENT_DATE, NULL);
INSERT INTO actors (first_name, last_name, created_at, updated_at)
VALUES ('Tom', 'Cruise', CURRENT_DATE, NULL);