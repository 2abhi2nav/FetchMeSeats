package org.ar.allocation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "seat_count")
    private Long seatCount;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
