package org.ar.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ar.inventory.entity.Flight;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZoneInventoryResponse {

    private String name;
    private Long capacity;
    private Flight flight;
}
