package org.ar.apigateway.route;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class InventoryRoutes {

    @Bean
    public RouterFunction<ServerResponse> inventoryResponse() {

        return GatewayRouterFunctions.route("inventory-service")
                .route(
                        RequestPredicates.path("/api/v1/inventory/flight/{flightId}"),
                        request -> request.uri()
                )
                .route(
                        RequestPredicates.path("/api/v1/inventory/zone/{zoneId}"),
                        request -> forwardWithPathVariable(
                                request,
                                "zoneId",
                                "http://localhost:8080/api/v1/inventory/zone/"
                        )
                )
                .build();
    }

    private ServerResponse forwardWithPathVariable(ServerRequest request, String pathVariable, String baseUrl) {
        String value = request.pathVariable(pathVariable);
        return HandlerFunctions.http(baseUrl + value).handle(request);
    }
}
