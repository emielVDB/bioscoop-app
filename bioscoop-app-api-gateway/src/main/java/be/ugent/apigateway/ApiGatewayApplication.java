package be.ugent.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Patient service routes
                .route(r -> r.host("*").and().path("/patient/**").uri("http://localhost:2222"))
                // Reception service routes
                .route(r -> r.host("*").and().path("/reception/**").uri("http://localhost:2223"))

                // it is also possible to give independent paths:
                // .route(r ->
                // r.host("*").and().path("/patients").uri("http://localhost:2222/patients") )

                .build();
    }
}
