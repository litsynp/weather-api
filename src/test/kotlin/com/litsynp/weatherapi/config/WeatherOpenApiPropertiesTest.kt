package com.litsynp.weatherapi.config

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WeatherOpenApiPropertiesTest {

    @Autowired
    private lateinit var weatherOpenApiProperties: WeatherOpenApiProperties

    @Test
    fun test() {
        assertThat(weatherOpenApiProperties.kma.baseUrl).isNotNull
        assertThat(weatherOpenApiProperties.kma.serviceKeyEncoded).isNotNull
    }
}
