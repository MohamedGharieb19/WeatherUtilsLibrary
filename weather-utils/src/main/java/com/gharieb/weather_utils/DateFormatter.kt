package com.gharieb.weather_utils

import com.gharieb.weather_utils.DateUtils.isToday
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

object DateFormatter{
    fun formatDateToToday(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getDefault()

        val outputFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        outputFormat.timeZone = TimeZone.getDefault()

        return if (isToday(dateString, inputFormat)) {
            "Today: ${outputFormat.format(inputFormat.parse(dateString)!!)}"
        } else {
            dateString
        }
    }

    fun formatDateToDayOrToday(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getDefault()

        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        dayFormat.timeZone = TimeZone.getDefault()

        return if (isToday(dateString, inputFormat)) {
            "Today"
        } else {
            dayFormat.format(inputFormat.parse(dateString)!!)
        }
    }
}

