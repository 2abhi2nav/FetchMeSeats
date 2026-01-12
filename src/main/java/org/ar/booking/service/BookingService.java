package org.ar.booking.service;

import org.ar.booking.entity.Passenger;
import org.ar.booking.repository.PassengerRepository;
import org.ar.booking.request.BookingRequest;
import org.ar.booking.response.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private PassengerRepository passengerRepository;

    public BookingResponse createBooking(BookingRequest bookingRequest) {
        Passenger passenger = passengerRepository.findById(bookingRequest.getPassengerId()).orElse(null);
        if (passenger == null) {
            throw new RuntimeException("User not found");
        }


        return BookingResponse.builder().build();
    }
}
