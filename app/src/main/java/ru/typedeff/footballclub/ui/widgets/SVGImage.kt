package ru.typedeff.footballclub.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import ru.typedeff.footballclub.R

@Composable
fun SVGImage(url:String){
    if(url.isEmpty())
        return
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(url)
            .decoderFactory(SvgDecoder.Factory())
            .placeholder(R.drawable.placeholder)
            .build()
    )

    return Image(painter = painter, contentDescription = null, modifier = Modifier.size(32.dp))

}