package ru.typedeff.footballclub.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone


fun String.toTimeFormat(): String{

    val dateTimeFormat = SimpleDateFormat(dateFormateStringFromApi,   Locale.ENGLISH)
    dateTimeFormat.timeZone = TimeZone.getTimeZone("UTC");

    val timeFormatWithTimeZone = SimpleDateFormat(timeFormateStringToDisplay,  Locale.getDefault())
    timeFormatWithTimeZone.setTimeZone(TimeZone.getDefault());

    val dateTime = dateTimeFormat.parse(this)
    val result = timeFormatWithTimeZone.format(dateTime?:"")


    return result
}
