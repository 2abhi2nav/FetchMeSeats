CREATE TABLE IF NOT EXISTS flight (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    capacity BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS zone (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    capacity BIGINT NOT NULL,
    flight_id BIGINT NOT NULL,
    CONSTRAINT fk_zone_flight FOREIGN KEY (flight_id) REFERENCES flight(id) ON DELETE CASCADE
);

INSERT INTO flight (name, destination, capacity)
VALUES
    ('AE5683', 'Ethiopia', 120),
    ('QT3425', 'Oman', 230);

INSERT INTO zone (name, capacity, flight_id)
VALUES
    ("First class", 40, 1),
    ("Economy", 80, 1),
    ("Business class", 58, 2);