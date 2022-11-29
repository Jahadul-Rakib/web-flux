package com.rakib.officemanagement.configuration.security;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class JwtFilter implements WebFilter {

    //TODO add path matcher in here

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        var request = exchange.getRequest ();
        var headers = exchange.getRequest ().getHeaders ();

//        if (headers.containsKey ("authorization")) {
//            return chain.filter (exchange);
//        }
//        throw new SecurityException ("No JWT token was provided");


        return chain.filter (exchange);

    }
}
