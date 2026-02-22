package org.ar.apigateway.route;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class InventoryRoutes {

    @Bean
    public RouterFunction<ServerResponse> routeToInventory() {

        return GatewayRouterFunctions.route("inventory-service")
                .route(path("/api/v1/inventory/**"), http())
                .before(uri("http://localhost/8080"))
                .build();
    }
}
