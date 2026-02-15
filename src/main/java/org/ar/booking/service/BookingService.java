package org.ar.booking.service;

import org.ar.booking.client.InventoryClient;
import org.ar.booking.entity.Passenger;
import org.ar.booking.event.BookingEvent;
import org.ar.booking.repository.PassengerRepository;
import org.ar.booking.request.BookingRequest;
import org.ar.booking.response.BookingResponse;
import org.ar.booking.response.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BookingService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private InventoryClient inventoryClient;

    @Autowired
    private KafkaTemplate<String, BookingEvent> kafkaTemplate;

    // check if user exists
    public BookingResponse createBooking(BookingRequest bookingRequest) {

        Passenger passenger = passengerRepository.findById(bookingRequest.getPassengerId()).orElse(null);
        if (passenger == null) {
            throw new RuntimeException("User not found");
        }

        // check if there are enough seats
        InventoryResponse inventoryResponse = inventoryClient.getInventoryByZone(bookingRequest.getZoneId());
        if (inventoryResponse.getCapacity() < bookingRequest.getSeatCount()) {
            throw new RuntimeException("Insufficient capacity");
        }

        // create booking
        BookingEvent bookingEvent = new BookingEvent(
                bookingRequest.getPassengerId(),
                bookingRequest.getZoneId(),
                bookingRequest.getSeatCount(),
                BigDecimal.valueOf(bookingRequest.getSeatCount()).multiply(inventoryResponse.getSeatPrice())
        );

        // send booking to the order service via a Kafka topic
        kafkaTemplate.send("booking", bookingEvent);

        return new BookingResponse(
                bookingEvent.getPassengerId(),
                bookingEvent.getZoneId(),
                bookingEvent.getSeatCount(),
                bookingEvent.getTotalPrice()
        );
    }

}
