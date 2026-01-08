package org.ar.allocation.service;

import org.ar.allocation.entity.Booking;
import org.ar.allocation.entity.Flight;
import org.ar.allocation.repository.BookingRepository;
import org.ar.allocation.repository.FlightRepository;
import org.ar.allocation.response.BookingInventoryResponse;
import org.ar.allocation.response.FlightInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    public List<BookingInventoryResponse> getAllBookings() {
        final List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream().map(booking -> BookingInventoryResponse.builder()
                .id(booking.getId())
                .seatCount(booking.getSeatCount())
                .flight(booking.getFlight())
                .build()).collect(Collectors.toList());
    }

    public FlightInventoryResponse getFlightInfo(Long flightId) {
        final Flight flight = flightRepository.findById(flightId).orElse(   null);

        return FlightInventoryResponse.builder()
                .id(flight.getId())
                .name(flight.getName())
                .destination(flight.getDestination())
                .capacity(flight.getCapacity())
                .build();
    }
}
