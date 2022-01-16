CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    created TIMESTAMP DEFAULT current_timestamp NOT NULL,
    updated TIMESTAMP DEFAULT current_timestamp NOT NULL,
    status VARCHAR(25) DEFAULT 'NOT_CONFIRMED' NOT NULL
);

OK