package org.ar.allocation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightInventoryResponse {

    private String name;
    private String destination;
    private Long capacity;
}
