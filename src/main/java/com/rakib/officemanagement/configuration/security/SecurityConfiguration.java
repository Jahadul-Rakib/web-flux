package com.rakib.officemanagement.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    SecurityWebFilterChain apiHttpSecurity(ServerHttpSecurity http) {
        return http
                .csrf ().disable ()
                .cors ().disable ()
                .authorizeExchange ()
                //.pathMatchers ("/api/**").permitAll ()
                .anyExchange ().permitAll ()
                .and ()
                .addFilterBefore (jwtFilter(), SecurityWebFiltersOrder.AUTHORIZATION)
                .build ();
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }
}
