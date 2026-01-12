package org.ar.booking.client;

import org.ar.booking.response.InventoryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class InventoryClient {

    @Value("${inventory.url}")
    private String inventoryUrl;

    public InventoryResponse getInventoryZone(final Long zoneId) {
        final RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(inventoryUrl + "/zone/" + zoneId, InventoryResponse.class);
    }
}
