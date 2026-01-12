CREATE TABLE reservation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    total DECIMAL(10, 2) NOT NULL,
    seatCount BIGINT NOT NULL,
    booked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    passenger_id BIGINT,
    zone_id BIGINT,
    CONSTRAINT fk_reservation_passenger FOREIGN KEY (passenger_id) REFERENCES passenger(id) ON DELETE SET NULL,
    CONSTRAINT fk_reservation_zone FOREIGN KEY (passenger_id) REFERENCES zone(id) ON DELETE SET NULL
);