package com.litsynp.weatherapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherOpenApiApplication

fun main(args: Array<String>) {
    runApplication<WeatherOpenApiApplication>(*args)
}
