package com.gorkhacloud.uicomponent.radio.radiolist.simple

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
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
fun SimpleRadioList(
    items: List<SimpleRadioListData>,
    modifier: Modifier = Modifier,
    selectedPosition: Int? = null,
    onClick: (Int, String) -> Unit
) {

    var selectedOption by remember {
        mutableStateOf(selectedPosition?.let { items.getOrNull(it) }
            ?: items.firstOrNull { it.isSelected })
    }
    val containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
    val outlineVariantColor = MaterialTheme.colorScheme.outlineVariant
    val shape = MaterialTheme.shapes.small

    LazyColumn(
        modifier.selectableGroup(), verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(items) { index, item ->
            key(item.id) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .noIndicationSelectable(
                            selected = (item == selectedOption), onClick = {
                                selectedOption = item
                                onClick(index, item.id)
                            }, role = Role.RadioButton
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
                        Text(item.title)
                        RadioButton((item == selectedOption), onClick = null)
                    }
                }
            }
        }
    }


}


@Preview(showSystemUi = true)
@Composable
fun SimpleRadioListPreview() {
    SimpleRadioList(
        items = listOf(
            SimpleRadioListData(
                id = "1", title = "Economy"
            ), SimpleRadioListData(
                id = "1", title = "Premium"
            ), SimpleRadioListData(
                id = "1", title = "Luxury"
            )
        ), selectedPosition = 1
    ) { index, item ->


    }

}