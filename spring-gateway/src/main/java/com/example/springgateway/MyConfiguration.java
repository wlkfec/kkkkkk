package com.example.springgateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class MyConfiguration {

    @Bean("wjkRouteLocator")
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route(predicateSpec -> predicateSpec
                .path("/wjk")
                .filters(gatewayFilterSpec -> gatewayFilterSpec.stripPrefix(1))
                .uri("http://www.baidu.com/")).build();
    }

    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }


    public static class CustomGlobalFilter implements GlobalFilter, Ordered {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info(exchange.getAttributes().toString());
            log.info("custom global filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("AFilter后置逻辑");
            }));
        }

        @Override
        public int getOrder() {
            return -1;
        }
    }

}
