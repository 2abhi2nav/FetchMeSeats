package org.ar.booking.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class FlightResponse {
    
    private Long id;
    private String name;
    private String destination;
    private Long capacity;
}
