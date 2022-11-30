package com.rakib.officemanagement.configuration;

import com.rakib.officemanagement.service.HealthCheckingService;
import com.rakib.officemanagement.service.UserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
@EnableWebFluxSecurity
public class RouterConfiguration {

    private final HealthCheckingService healthCheckingService;
    private final UserInfoService userInfoService;

    public RouterConfiguration(HealthCheckingService healthCheckingService, UserInfoService userInfoService) {
        this.healthCheckingService = healthCheckingService;
        this.userInfoService = userInfoService;
    }

    @Bean
    RouterFunction<ServerResponse> baseRouterFunction() {
        return RouterFunctions.route ()
                .path ("/", builder -> builder
                        .GET (RequestPredicates.accept (MediaType.APPLICATION_JSON), healthCheckingService::getHealthStatus)
                        .GET ("/health", RequestPredicates.accept (MediaType.APPLICATION_JSON), healthCheckingService::getHealthStatus))
                .path ("/user", builder -> builder
                        .POST (RequestPredicates.accept (MediaType.APPLICATION_JSON), userInfoService::createUserInfo))
                .build ();
    }
}
