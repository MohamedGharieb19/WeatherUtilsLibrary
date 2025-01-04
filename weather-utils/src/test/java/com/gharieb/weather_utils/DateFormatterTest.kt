package com.gharieb.weather_utils

import org.junit.Assert.assertEquals
import org.junit.Test

class DateFormatterTest {

    @Test
    fun `formatDateToToday formats today's date correctly`() {
        // Arrange
        val today = "2025-01-04 14:00"
        val expected = "Today: 02:00 PM"

        // Act
        val result = DateFormatter.formatDateToToday(today)

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun `formatDateToToday returns original string for non-today dates`() {
        // Arrange
        val notToday = "2025-01-03 14:00"

        // Act
        val result = DateFormatter.formatDateToToday(notToday)

        // Assert
        assertEquals(notToday, result)
    }

    @Test
    fun `formatDateToToday returns original string for invalid date`() {
        // Arrange
        val invalidDate = "InvalidDateString"

        // Act
        val result = DateFormatter.formatDateToToday(invalidDate)

        // Assert
        assertEquals(invalidDate, result)
    }

    @Test
    fun `formatDateToDayOrToday returns 'Today' for today's date`() {
        // Arrange
        val today = "2025-01-04"
        val expected = "Today"

        // Act
        val result = DateFormatter.formatDateToDayOrToday(today)

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun `formatDateToDayOrToday returns day of the week for past dates`() {
        // Arrange
        val pastDate = "2025-01-03" // Assume this is a Friday
        val expected = "Friday"

        // Act
        val result = DateFormatter.formatDateToDayOrToday(pastDate)

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun `formatDateToDayOrToday returns original string for invalid date`() {
        // Arrange
        val invalidDate = "InvalidDateString"

        // Act
        val result = DateFormatter.formatDateToDayOrToday(invalidDate)

        // Assert
        assertEquals(invalidDate, result)
    }
}