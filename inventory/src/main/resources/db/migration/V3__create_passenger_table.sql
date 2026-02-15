CREATE TABLE passenger (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255)
);

INSERT INTO passenger (name, email, address)
VALUES
    ('Jamie', 'jamieoliwer04@mail.com', '220, Privet Drive'),
    ('Foxie', 'foxythefox@mail.com', 'Diagon Alley');