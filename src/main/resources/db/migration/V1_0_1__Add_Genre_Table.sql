
CREATE TABLE IF NOT EXISTS genre (
     id serial PRIMARY KEY,
     name VARCHAR (50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL
)