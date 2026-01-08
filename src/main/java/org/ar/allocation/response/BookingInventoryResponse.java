package org.ar.allocation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ar.allocation.entity.Flight;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingInventoryResponse {

    private Long id;
    private Long seatCount;
    private Flight flight;
}
