package com.rakib.officemanagement.service.utility_service;

import com.rakib.officemanagement.service.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class CommonUtils {

    public static Mono<ServerResponse> successResponse(HttpStatus status, String message, Object data) {
        return ServerResponse
                .status (status.value ())
                .body (ResponseDTO.builder ().status (status).message (message).data (data).build (), Object.class);
    }
}
