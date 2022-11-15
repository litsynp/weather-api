package com.litsynp.weatherapi.infra

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.test.StepVerifier
import java.time.LocalDate

@SpringBootTest
class WeatherOpenApiRepositoryTest {

    @Autowired
    private lateinit var weatherOpenApiRepository: WeatherOpenApiRepository

    @Test
    fun `getVillageForecast should return OK`() {
        val villageForecast = weatherOpenApiRepository.getVillageForecast(
            baseDate = LocalDate.now().toString().replace("-", ""),
            baseTime = "0500",
            nx = 62,
            ny = 126
        )
            .log()

        StepVerifier.create(villageForecast)
            .expectNextMatches { it.isNotEmpty() }
            .verifyComplete()
    }
}
