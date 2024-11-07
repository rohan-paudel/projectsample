package com.gorkhacloud.uicomponent.cards

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.gorkhacloud.uicomponent.R
import com.gorkhacloud.uicomponent.text.VerticalCardBottomTextTitle

@Composable
fun VerticalCard(
    image: String, title: String, modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val loadingImage = painterResource(R.drawable.loading)

    Column(
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context).data(image).crossfade(true).build(),
            placeholder = loadingImage,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(4.dp))
        VerticalCardBottomTextTitle(title, 96.dp)
    }
}


@Composable
fun VerticalCard(
    @DrawableRes image: Int, title: String, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(4.dp))
        VerticalCardBottomTextTitle(title, 96.dp)

    }
}


@Preview(showBackground = true)
@Composable
fun VerticalCardNetworkPreview() {
    VerticalCard(
        "https://picsum.photos/seed/picsum/1920/1080", "Title Here"
    )
}

@Preview(showBackground = true)
@Composable
fun VerticalCardLocalPreview() {
    VerticalCard(
        R.drawable.img, "Title Here is the long what will be in long"
    )
}
