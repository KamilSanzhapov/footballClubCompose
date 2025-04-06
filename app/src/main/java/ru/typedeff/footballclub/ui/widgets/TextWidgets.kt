package ru.typedeff.footballclub.ui.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle(str: String) {
    TextBase(str, 18.sp)
}

@Composable
fun TextNormal(str: String) {
    TextBase(str, 14.sp)
}

@Composable
fun TextSmall(str: String) {
    TextBase(str, 12.sp)
}


@Composable
fun TextBase(str: String, textSize: TextUnit) {
    Text(
        text = str,
        modifier = Modifier.padding(horizontal = 16.dp),
        fontSize = textSize,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onBackground
    )
}