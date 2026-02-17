package org.ar.shared.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
