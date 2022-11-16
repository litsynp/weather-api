package com.litsynp.weatherapi.api.request

import java.time.LocalDate
import java.time.LocalTime

data class VillageForecastRequest(
    val numOfRows: Int = 10,
    val page: Int = 1,
    val baseDate: LocalDate,
    val baseTime: LocalTime,
    val nx: Int,
    val ny: Int,
) {
    val baseDateStr: String
        get() = baseDate.toString().replace("-", "")

    val baseTimeStr: String
        get() = baseTime.toString().replace(":", "")
}
