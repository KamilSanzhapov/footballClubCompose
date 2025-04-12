package ru.typedeff.footballclub.utils

import java.time.format.DateTimeFormatter

val dateFormateStringFromApi = "yyyy-MM-dd'T'HH:mm:ss'Z'"
val dateFormateFromApi = DateTimeFormatter.ofPattern(dateFormateStringFromApi)

val timeFormateStringToDisplay  = "HH:mm"

val dateFormateStringToDisplay = "dd MMMM yyyy г."
val dateFormateToDisplay = DateTimeFormatter.ofPattern(dateFormateStringToDisplay)
