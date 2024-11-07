package com.gorkhacloud.uicomponent.radio

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorkhacloud.uicomponent.modifier.noIndicationSelectable

@Composable
fun SimpleRadio(
    title: String,
    onClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    initiallySelected: Boolean = true
) {
    var isSelected by remember { mutableStateOf(initiallySelected) }

    val containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
    val outlineVariantColor = MaterialTheme.colorScheme.outlineVariant
    val shape = MaterialTheme.shapes.small

    val handleClick: () -> Unit = remember {
        {
            isSelected = !isSelected
            onClick(isSelected)
        }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .noIndicationSelectable(
                selected = isSelected, onClick = handleClick, role = Role.RadioButton
            ),
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = containerColor),
        border = BorderStroke(1.dp, outlineVariantColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text(title)
            RadioButton(selected = isSelected, onClick = null)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DecoratedRadioPreview() {
    SimpleRadio("Title", {})
}