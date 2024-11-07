package com.gorkhacloud.uicomponent.cards.cardlist.simple

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gorkhacloud.uicomponent.cards.VerticalCard
import com.gorkhacloud.uicomponent.modifier.noIndicationClickable

@Composable
fun SimpleCardList(
    items: List<SimpleCardListData>,
    modifier: Modifier = Modifier,
    selectionTitle: String = "Selection Title",
    actionTitle: String = "View More",
    onActionTitleClick: () -> Unit = {},
    onCardClick: (String) -> Unit = {},
) {
    Column(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(selectionTitle)
            Text(actionTitle, modifier = Modifier.noIndicationClickable {
                onActionTitleClick()
            }, style = MaterialTheme.typography.labelLarge)
        }
        CardBottomRow(items, onCardClick)
    }
}

@Composable
fun SimpleCardList(
    items: List<SimpleCardListData>,
    modifier: Modifier = Modifier,
    onCardClick: (String) -> Unit = {},
    headerContent: @Composable (() -> Unit) = {}
) {
    Column(
        modifier = modifier
    ) {
        headerContent()
        CardBottomRow(items, onCardClick)
    }
}

@Composable
private fun CardBottomRow(items: List<SimpleCardListData>, onCardClick: (String) -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            VerticalCard(item.imageUrl, item.title, modifier = Modifier.noIndicationClickable {
                onCardClick(
                    item.id
                )
            })
        }
    }
}