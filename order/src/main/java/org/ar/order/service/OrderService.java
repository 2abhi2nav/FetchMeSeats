package org.ar.order.service;

import org.ar.order.client.InventoryClient;
import org.ar.order.entity.Order;
import org.ar.order.repository.OrderRepository;
import org.ar.shared.event.BookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryClient inventoryClient;

    @KafkaListener(topics = "booking", groupId = "order")
    public void orderEvent(BookingEvent bookingEvent) {

        // create order
        Order order = createOrder(bookingEvent);
        orderRepository.saveAndFlush(order);

        //update inventory
        inventoryClient.updateInventory(order.getZoneId(), order.getSeatCount());
    }

    private Order createOrder(BookingEvent bookingEvent) {
        return Order.builder()
                .passengerId(bookingEvent.getPassengerId())
                .zoneId(bookingEvent.getZoneId())
                .seatCount(bookingEvent.getSeatCount())
                .totalPrice(bookingEvent.getTotalPrice())
                .build();
    }
}