package br.com.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(route -> route.path("/get")
                        .filters(filter -> filter
                                .addRequestHeader("Hello", "World")
                                .addRequestParameter("Hello", "World"))

                        .uri("http://httpbin.org:80"))
                .route(route -> route.path("/cambio-service/**").uri("lb://cambio-service"))
                .route(route -> route.path("/book-service/**").uri("lb://book-service"))
                .build();
    }
}
