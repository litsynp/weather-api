package com.litsynp.weatherapi.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "weather.open-api")
data class WeatherOpenApiProperties(
    val kma: KmaProperties,
) {
    data class KmaProperties(
        val baseUrl: String,
        val serviceKeyEncoded: String,
    )
}
