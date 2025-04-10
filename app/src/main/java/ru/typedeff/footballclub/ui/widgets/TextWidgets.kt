package ru.typedeff.footballclub.ui.widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle(str: String, modifier: Modifier = Modifier) {
    TextBase(str, 18.sp, modifier = modifier)
}

@Composable
fun TextNormal(str: String, modifier: Modifier = Modifier) {
    TextBase(str, 14.sp,modifier )
}

@Composable
fun TextSmall(str: String, modifier: Modifier = Modifier, maxLines:Int = 1,  textAlign: TextAlign? =null) {
    TextBase(str, 12.sp, modifier, maxLines, textAlign, FontWeight.Normal)
}


@Composable
fun TextBase(
    str: String,
    textSize: TextUnit,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    textAlign: TextAlign? =null,
    fontWeight: FontWeight? =null
) {
    Text(
        text = str,
        maxLines = maxLines,
        modifier = modifier,
        fontSize = textSize,
        fontWeight = fontWeight ?: FontWeight.Medium,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = textAlign

    )
}