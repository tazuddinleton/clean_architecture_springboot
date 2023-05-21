
CREATE TABLE IF NOT EXISTS actor (
    id serial PRIMARY KEY,
    first_name VARCHAR (50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NULL
)