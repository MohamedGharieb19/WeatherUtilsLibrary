package com.gharieb.weather_utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object DateFormatter {
    private val DEFAULT_LOCALE = Locale.US
    private val DEFAULT_TIMEZONE = TimeZone.getTimeZone("UTC")

    fun formatDateToToday(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", DEFAULT_LOCALE).apply {
            timeZone = DEFAULT_TIMEZONE
        }
        val outputFormat = SimpleDateFormat("hh:mm a", DEFAULT_LOCALE).apply {
            timeZone = DEFAULT_TIMEZONE
        }

        return try {
            val date = inputFormat.parse(dateString)
            if (date != null && isToday(date)) {
                "Today: ${outputFormat.format(date)}"
            } else {
                dateString
            }
        } catch (e: ParseException) {
            dateString // Return the original string if parsing fails
        }
    }

    fun formatDateToDayOrToday(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", DEFAULT_LOCALE).apply {
            timeZone = DEFAULT_TIMEZONE
        }
        val dayFormat = SimpleDateFormat("EEEE", DEFAULT_LOCALE).apply {
            timeZone = DEFAULT_TIMEZONE
        }

        return try {
            val date = inputFormat.parse(dateString)
            if (date != null && isToday(date)) {
                "Today"
            } else {
                dayFormat.format(date!!)
            }
        } catch (e: ParseException) {
            dateString
        }
    }

     fun isToday(date: Date): Boolean {
        val calendar = Calendar.getInstance(DEFAULT_TIMEZONE, DEFAULT_LOCALE)
        val today = Calendar.getInstance(DEFAULT_TIMEZONE, DEFAULT_LOCALE).apply {
            timeInMillis = calendar.timeInMillis
        }
        val target = Calendar.getInstance(DEFAULT_TIMEZONE, DEFAULT_LOCALE).apply {
            time = date
        }
        return today.get(Calendar.YEAR) == target.get(Calendar.YEAR) &&
                today.get(Calendar.DAY_OF_YEAR) == target.get(Calendar.DAY_OF_YEAR)
    }
}

