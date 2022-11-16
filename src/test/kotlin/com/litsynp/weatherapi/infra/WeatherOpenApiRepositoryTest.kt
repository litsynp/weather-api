package com.litsynp.weatherapi.infra

import com.litsynp.weatherapi.api.request.VillageForecastRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.test.StepVerifier
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period

@SpringBootTest
class WeatherOpenApiRepositoryTest {

    @Autowired
    private lateinit var weatherOpenApiRepository: WeatherOpenApiRepository

    @Test
    fun `getVillageForecast should return OK`() {
        println(LocalDate.now().minusDays(1))
        println(LocalTime.of(9, 0))

        val villageForecast = weatherOpenApiRepository.getVillageForecast(
            VillageForecastRequest(
                baseDate = LocalDate.now().minusDays(1),
                baseTime = LocalTime.of(5, 0),
                nx = 62,
                ny = 126
            )
        )
            .log()

        StepVerifier.create(villageForecast)
            .expectNextMatches { it.isNotEmpty() }
            .verifyComplete()
    }
}
