package org.ar.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "seat_count")
    private Long seatCount;

    @CreationTimestamp
    @Column(name = "booked_at", updatable = false, nullable = false)
    private LocalDateTime bookedAt;

    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "zone_id")
    private Long zoneId;
}
