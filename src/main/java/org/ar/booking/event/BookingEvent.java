package org.ar.booking.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingEvent {

    private Long passengerId;
    private Long zoneId;
    private Long seatCount;
    private BigDecimal totalPrice;
}
