package org.ar.booking.controller;

import org.ar.booking.request.BookingRequest;
import org.ar.booking.response.BookingResponse;
import org.ar.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/booking")
    public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }
}
