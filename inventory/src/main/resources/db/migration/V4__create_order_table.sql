CREATE TABLE `order` (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    total_price DECIMAL(10, 2) NOT NULL,
    seat_count BIGINT NOT NULL,
    booked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    passenger_id BIGINT,
    zone_id BIGINT,
    CONSTRAINT fk_order_passenger FOREIGN KEY (passenger_id) REFERENCES passenger(id) ON DELETE SET NULL,
    CONSTRAINT fk_order_zone FOREIGN KEY (zone_id) REFERENCES zone(id) ON DELETE SET NULL
);