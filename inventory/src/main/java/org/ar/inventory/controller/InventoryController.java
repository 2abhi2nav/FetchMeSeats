package org.ar.inventory.controller;

import org.ar.inventory.response.ZoneInventoryResponse;
import org.ar.inventory.response.FlightInventoryResponse;
import org.ar.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory/zones")
    public List<ZoneInventoryResponse> getAllZones() {
        return inventoryService.getAllZones();
    }

    @GetMapping("/inventory/zone/{zoneId}")
    public ZoneInventoryResponse getZoneInfo(@PathVariable("zoneId") Long zoneId) {
        return inventoryService.getZoneInfo(zoneId);
    }

    @GetMapping("/inventory/flight/{flightId}")
    public FlightInventoryResponse getFlightInfo(@PathVariable("flightId") Long flightId) {
        return inventoryService.getFlightInfo(flightId);
    }

    @PutMapping("/inventory/zone/{zoneId}/capacity/{capacity}")
    public ResponseEntity<Void> updateZoneCapacity(
            @PathVariable("zoneId") Long zoneId,
            @PathVariable("capacity") Long seatsBooked
    ) {
        inventoryService.updateZoneCapacity(zoneId, seatsBooked);
        return ResponseEntity.ok().build();
    }
}
