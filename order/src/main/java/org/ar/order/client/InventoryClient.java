package org.ar.order.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryClient {

    @Value("${inventory.url}")
    public String inventoryUrl;

    public ResponseEntity<Void> updateInventory(
            Long zoneId,
            Long seatCount
    ) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(inventoryUrl + "/zone/" + zoneId + "/capacity/" + seatCount, null);
        return ResponseEntity.ok().build();
    }
}
