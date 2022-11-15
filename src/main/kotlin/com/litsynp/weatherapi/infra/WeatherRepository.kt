package com.litsynp.weatherapi.infra

import com.litsynp.weatherapi.config.WeatherOpenApiProperties
import com.litsynp.weatherapi.exception.WeatherApiException
import org.springframework.http.MediaType
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.DefaultUriBuilderFactory
import reactor.core.publisher.Mono

@Repository
class WeatherOpenApiRepository(
    private val weatherOpenApiProperties: WeatherOpenApiProperties,
) {
    private final val webClient = WebClient.builder()
        .uriBuilderFactory(DefaultUriBuilderFactory(weatherOpenApiProperties.kma.baseUrl)
            .apply { encodingMode = DefaultUriBuilderFactory.EncodingMode.NONE })
        .build()

    fun getVillageForecast(
        numOfRows: Int = 10,
        page: Int = 1,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int,
    ): Mono<String> {
        return webClient.get()
            .uri { uriBuilder ->
                uriBuilder.path("/getVilageFcst")
                    .queryParam("serviceKey", weatherOpenApiProperties.kma.serviceKeyEncoded)
                    .queryParam("dataType", "JSON")
                    .queryParam("numOfRows", numOfRows)
                    .queryParam("pageNo", page)
                    .queryParam("base_date", baseDate)
                    .queryParam("base_time", baseTime)
                    .queryParam("nx", nx)
                    .queryParam("ny", ny)
                    .build()
            }
            .header("Accept", MediaType.APPLICATION_JSON_VALUE)
            .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .onStatus({ it.isError }, { Mono.error(WeatherApiException()) })
            .bodyToMono(String::class.java)
    }
}
