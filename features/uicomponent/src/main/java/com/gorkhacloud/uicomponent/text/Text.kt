package com.gorkhacloud.uicomponent.text

import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp

@Composable
fun VerticalCardBottomTextTitle(title: String, size: Dp) {
    Text(
        text = title,
        modifier = Modifier.width(size),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleSmall
    )
}