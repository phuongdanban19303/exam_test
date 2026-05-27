package com.example.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class LoggingGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String method = exchange.getRequest().getMethod().name();
        String uri = exchange.getRequest().getURI().toString();
        LocalDateTime time = LocalDateTime.now();

        System.out.println("===== API GATEWAY LOG =====");
        System.out.println("Time   : " + time);
        System.out.println("Method : " + method);
        System.out.println("URI    : " + uri);
        System.out.println("===========================");

        return chain.filter(exchange);
    }
}
