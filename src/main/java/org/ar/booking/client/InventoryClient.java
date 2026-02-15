package org.ar.booking.client;

import org.ar.booking.response.InventoryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryClient {

    @Value("${inventory.url}")
    private String inventoryUrl;

    public InventoryResponse getInventoryByZone(final Long zoneId) {
        final RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(inventoryUrl + "/zone/" + zoneId, InventoryResponse.class);
    }
}
