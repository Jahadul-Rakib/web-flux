package com.rakib.officemanagement.service.service_impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class HealthCheckingService{
    public Mono<ServerResponse> getHealthStatus(ServerRequest serverRequest) {
        return ServerResponse.status (HttpStatus.CREATED).body (BodyInserters.fromValue ("running----!!!"));
    }
}
