package com.litsynp.weatherapi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Year
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class ZonedDateTimeTest {

    @Test
    fun toStringTest() {
        val zonedDateTime = Year.of(2022)
            .atMonth(11)
            .atDay(13)
            .atTime(1, 25, 30)
            .atZone(ZoneOffset.UTC)

        val formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .withZone(ZoneOffset.UTC)

        assertThat(formatter.format(zonedDateTime)).isEqualTo("2022-11-13T01:25:30Z")
    }
}
