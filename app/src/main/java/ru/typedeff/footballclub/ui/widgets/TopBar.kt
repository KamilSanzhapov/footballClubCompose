package ru.typedeff.footballclub.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.typedeff.footballclub.R

@Composable
fun TopBarIcon(
    img: ImageVector, isInvisible: Boolean = false, click: (() -> Unit)? = null
) {
    Icon(
        tint = MaterialTheme.colorScheme.onBackground,
        imageVector = img,
        contentDescription = "",
        modifier = Modifier
            .alpha(if (isInvisible) 0f else 1f)
            .clickable {
                click?.invoke()
            }
            .size(dimensionResource(R.dimen.top_bar_size))
            .padding(10.dp))
}

@Preview()
@Composable
fun TopBar(
    title: String = "",
    centerLogo: String = "",
    leftIcon: (@Composable () -> Unit)? = null,
    onLeftClick: (() -> Unit)? = null,
    rightIcon: (@Composable () -> Unit)? = null,
    onRightClick: (() -> Unit)? = null
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.top_bar_size))
                .background(color = MaterialTheme.colorScheme.primary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftIcon?.invoke() ?: run {
                TopBarIcon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    (leftIcon == null && onLeftClick == null),
                    onLeftClick
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            SVGImage(centerLogo)
            TextTitle(title, Modifier.padding(start = 8.dp))
            Spacer(modifier = Modifier.weight(1f))
            rightIcon?.invoke() ?: run {
                TopBarIcon(
                    Icons.Rounded.Settings,
                    (rightIcon == null && onRightClick == null),
                    onRightClick
                )
            }
        }
    }

}
