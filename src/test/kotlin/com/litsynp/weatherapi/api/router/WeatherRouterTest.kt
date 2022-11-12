package com.litsynp.weatherapi.api.router

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherRouterTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun `get weather`() {
        webTestClient.get().uri("/weathers/short")
            .exchange()
            .expectStatus().isOk
    }
}
