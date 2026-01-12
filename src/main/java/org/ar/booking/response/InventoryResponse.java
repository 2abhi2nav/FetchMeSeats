package org.ar.booking.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {

    private Long id;
    private String name;
    private Long capacity;
    private BigDecimal ticketPrice;
    private FlightResponse flight;
}
