package org.ar.inventory.controller;

import org.ar.inventory.response.ZoneInventoryResponse;
import org.ar.inventory.response.FlightInventoryResponse;
import org.ar.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/inventory/flights/{flightId}")
    public FlightInventoryResponse getFlightInfo(@PathVariable("flightId") Long flightId) {
        return inventoryService.getFlightInfo(flightId);
    }
}
