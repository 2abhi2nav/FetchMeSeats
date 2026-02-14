package org.ar.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ar.inventory.entity.Flight;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZoneInventoryResponse {

    private Long id;
    private String name;
    private Long capacity;
    private BigDecimal ticketPrice;
    private Flight flight;
}
