CREATE TABLE roles(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE users(
    id uuid PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,

    roles_id INT NOT NULL,
    FOREIGN KEY (roles_id) REFERENCES roles(id)
);

CREATE TABLE categories(
    id uuid PRIMARY KEY,
    name VARCHAR(30) UNIQUE NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL,

    user_id uuid NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE tourist_points(
    id uuid PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    open_time TIME,
    close_time TIME,
    accessibility_info TEXT,
    has_accessibility BOOLEAN NOT NULL DEFAULT FALSE,
    latitude NUMERIC(9, 6) NOT NULL,
    longitude NUMERIC(9, 6) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,

    user_id uuid NOT NULL,
    address_id uuid UNIQUE NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE tourist_point_categories(
    tourist_point_id uuid,
    category_id uuid,

    PRIMARY KEY (tourist_point_id, category_id),

    FOREIGN KEY (tourist_point_id) REFERENCES tourist_points(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE photos(
    id uuid PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    display_order INT NOT NULL,
    created_at TIMESTAMP NOT NULL,

    tourist_point_id uuid NOT NULL,
    FOREIGN KEY (tourist_point_id) REFERENCES tourist_points(id)
);

CREATE TABLE addresses(
    id uuid PRIMARY KEY,
    street VARCHAR(60) NOT NULL,
    number VARCHAR(6) NOT NULL,
    complement VARCHAR(40),
    neighborhood VARCHAR(60) NOT NULL,
    city VARCHAR(60) NOT NULL,
    state CHAR(2) NOT NULL,
    zip_code VARCHAR(9) NOT NULL,
    created_at TIMESTAMP NOT NULL,

    tourist_point_id uuid NOT NULL,
    FOREIGN KEY (tourist_point_id) REFERENCES tourist_points(id)
);

CREATE TABLE comments(
    id uuid PRIMARY KEY,
    content TEXT NOT NULL,
    note SMALLINT NOT NULL CHECK (note BETWEEN 1 AND 5),
    author_name VARCHAR(100),
    created_at TIMESTAMP NOT NULL,

    tourist_point_id uuid NOT NULL,
    user_id uuid,

    FOREIGN KEY (tourist_point_id) REFERENCES tourist_points(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

