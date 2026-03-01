package org.ar.apigateway.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class BookingRoutes {

    @Bean
    public RouterFunction<ServerResponse> routeToBooking() {

        return route("booking_routes")
                .route(path("/api/v1/booking/**"), http())
                .before(uri("http://localhost:8081"))
                .build();
    }
}