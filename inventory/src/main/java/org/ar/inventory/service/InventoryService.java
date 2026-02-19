package org.ar.inventory.service;

import org.ar.inventory.entity.Zone;
import org.ar.inventory.entity.Flight;
import org.ar.inventory.repository.ZoneRepository;
import org.ar.inventory.repository.FlightRepository;
import org.ar.inventory.response.ZoneInventoryResponse;
import org.ar.inventory.response.FlightInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private FlightRepository flightRepository;

    public List<ZoneInventoryResponse> getAllZones() {
        final List<Zone> zones = zoneRepository.findAll();

        return zones.stream().map(
                zone -> new ZoneInventoryResponse(
                        zone.getId(),
                        zone.getName(),
                        zone.getCapacity(),
                        zone.getTicketPrice(),
                        zone.getFlight()
                )
        ).collect(Collectors.toList());
    }

    public ZoneInventoryResponse getZoneInfo(Long zoneId) {
        final Zone zone = zoneRepository.findById(zoneId).orElse(null);

        return new ZoneInventoryResponse(
                zone.getId(),
                zone.getName(),
                zone.getCapacity(),
                zone.getTicketPrice(),
                zone.getFlight()
        );
    }

    public FlightInventoryResponse getFlightInfo(Long flightId) {
        final Flight flight = flightRepository.findById(flightId).orElse(null);

        return new FlightInventoryResponse(
                flight.getName(),
                flight.getDestination(),
                flight.getCapacity()
        );
    }

    public void updateZoneCapacity(Long zoneId, Long seatsBooked) {
        final Zone zone = zoneRepository.findById(zoneId).orElse(null);

        zone.setCapacity(zone.getCapacity() - seatsBooked);
        zoneRepository.saveAndFlush(zone);
    }
}
