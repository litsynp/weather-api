package com.litsynp.weatherapi.api.request

import java.time.ZonedDateTime

class WeatherRequest(
    val location: CoordinatesRequest,
    val time: ZonedDateTime,
)
