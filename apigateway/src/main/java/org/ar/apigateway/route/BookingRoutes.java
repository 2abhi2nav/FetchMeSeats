package org.ar.apigateway.route;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.cloud.gateway.server.mvc.handler.ProxyExchangeHandlerFunctions;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class BookingRoutes {

    @Bean
    public RouterFunction<ServerResponse> bookingRoutes() {
        return GatewayRouterFunctions.route("booking-service")
                .route(
                        RequestPredicates.POST("/api/v1/booking"),
                        http("http://localhost:8081/api/v1/booking")
                )
                .build();
    }
}