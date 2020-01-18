package be.ugent.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@SpringBootApplication
public class ApiGatewayApplication implements WebFluxConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .exposedHeaders(HttpHeaders.SET_COOKIE);
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addExposedHeader(HttpHeaders.SET_COOKIE);
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(corsConfigurationSource);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // ticket service routes
                .route(r -> r.host("**").and().path("/ticket/**").uri("http://localhost:2222"))
                // hallmgmt service routes
                .route(r -> r.host("**").and().path("/hall/**").uri("http://localhost:2221"))
                // schedule service routes
                .route(r -> r.host("**").and().path("/schedule/**").uri("http://localhost:2223"))
                // staff service routes
                .route(r -> r.host("**").and().path("/staff/**").uri("http://localhost:2224"))
                // media service routes
                .route(r -> r.host("**").and().path("/media/**").uri("http://localhost:2225"))

                // it is also possible to give independent paths:
                // .route(r ->
                // r.host("*").and().path("/patients").uri("http://localhost:2222/patients") )

                .build();
    }
}
