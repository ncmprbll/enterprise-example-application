DROP TABLE IF EXISTS coffee_machines;

CREATE TABLE coffee_machines (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(16) NOT NULL,
    model VARCHAR(16) NOT NULL,
    country_of_origin VARCHAR(16) NOT NULL,
    price DOUBLE PRECISION CHECK (price > 0)
)