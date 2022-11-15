package com.litsynp.weatherapi.support

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import reactor.core.publisher.Mono
import java.util.function.Consumer

inline fun <reified T> T.logger(): Logger {
    if (T::class.isCompanion) {
        return LoggerFactory.getLogger(T::class.java.enclosingClass)
    }
    return LoggerFactory.getLogger(T::class.java)
}

fun logRequest(log: Logger): ExchangeFilterFunction {
    return ExchangeFilterFunction.ofRequestProcessor { clientRequest ->
        log.info("Request: {} {}", clientRequest.method(), clientRequest.url())
        clientRequest.headers()
            .forEach { name, values -> values.forEach { value -> log.info("$name=$value") } }
        Mono.just(clientRequest)
    }
}

fun logResponse(log: Logger): ExchangeFilterFunction {
    return ExchangeFilterFunction.ofResponseProcessor { clientResponse ->
        log.info("Response status: {}", clientResponse.statusCode())
        clientResponse.headers().asHttpHeaders()
            .forEach { name, values ->
                values.forEach(Consumer { value ->
                    log.info("$name=$value")
                })
            }
        Mono.just(clientResponse)
    }
}
