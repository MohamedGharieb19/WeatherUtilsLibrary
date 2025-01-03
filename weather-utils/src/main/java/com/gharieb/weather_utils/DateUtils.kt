package com.gharieb.weather_utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

object DateUtils {

    fun isToday(dateString: String, inputFormat: SimpleDateFormat): Boolean {
        val parsedDate: Date = inputFormat.parse(dateString) ?: return false
        val today = Calendar.getInstance()
        val parsedCalendar = Calendar.getInstance().apply { time = parsedDate }

        return today.get(Calendar.YEAR) == parsedCalendar.get(Calendar.YEAR) &&
                today.get(Calendar.DAY_OF_YEAR) == parsedCalendar.get(Calendar.DAY_OF_YEAR)
    }

}