package org.ar.booking.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    private Long passengerId;
    private Long zoneId;
    private Long seatCount;
    private BigDecimal totalPrice;
}
