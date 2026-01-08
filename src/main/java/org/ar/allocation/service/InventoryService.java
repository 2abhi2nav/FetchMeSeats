package org.ar.allocation.service;

import org.ar.allocation.repository.BookingRepository;
import org.ar.allocation.repository.FlightRepository;
import org.ar.allocation.response.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    public List<InventoryResponse> getAllBookings() {

    }
}
