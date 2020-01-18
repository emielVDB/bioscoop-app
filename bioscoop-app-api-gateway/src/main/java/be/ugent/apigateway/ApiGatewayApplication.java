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
                // ticket service routes
                .route(r -> r.host("**").and().path("/ticket/**").uri("http://ticket:2222"))
                // hallmgmt service routes
                .route(r -> r.host("**").and().path("/hall/**").uri("http://hall:2221"))
                .route(r -> r.host("**").and().path("/eventhall/**").uri("http://hall:2221"))
                // schedule service routes
                .route(r -> r.host("**").and().path("/schedule/**").uri("http://schedule:2223"))
                // staff service routes
                .route(r -> r.host("**").and().path("/staff/**").uri("http://staff:2224"))
                // media service routes
                .route(r -> r.host("**").and().path("/media/**").uri("http://media:2225"))
                // advertisement service routes
                .route(r -> r.host("**").and().path("/advertisement/**").uri("http://advertisement:2226"))
                // catering service routes
                .route(r -> r.host("**").and().path("/catering/**").uri("http://catering:2227"))
                // statistics service routes
                .route(r -> r.host("**").and().path("/statistics/**").uri("http://statistics:2228"))



                // it is also possible to give independent paths:
                // .route(r ->
                // r.host("*").and().path("/patients").uri("http://localhost:2222/patients") )

                .build();
    }
}
