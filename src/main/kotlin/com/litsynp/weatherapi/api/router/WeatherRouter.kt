package com.litsynp.weatherapi.api.router

import com.litsynp.weatherapi.api.request.WeatherRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Configuration
class WeatherRouter {

    @Bean
    fun weatherRoutes(): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(GET("/weathers/short"), this::getShortWeather)
    }

    fun getShortWeather(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(WeatherRequest::class.java)
            .flatMap { ServerResponse.status(HttpStatus.OK).bodyValue(it) }
    }
}
