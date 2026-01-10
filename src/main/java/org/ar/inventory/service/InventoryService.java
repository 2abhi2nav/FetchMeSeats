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

        return zones.stream().map(zone -> ZoneInventoryResponse.builder()
                .name(zone.getName())
                .capacity(zone.getCapacity())
                .flight(zone.getFlight())
                .build()).collect(Collectors.toList());
    }

    public FlightInventoryResponse getFlightInfo(Long flightId) {
        final Flight flight = flightRepository.findById(flightId).orElse(   null);

        return FlightInventoryResponse.builder()
                .name(flight.getName())
                .destination(flight.getDestination())
                .capacity(flight.getCapacity())
                .build();
    }
}
