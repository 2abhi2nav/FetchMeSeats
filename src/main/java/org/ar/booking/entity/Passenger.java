package org.ar.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passenger")
public class Passenger {

    @Id
    private Long id;
    private String name;
    private String email;
    private String address;
}
