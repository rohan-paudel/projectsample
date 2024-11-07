package com.gorkhacloud.uicomponent.cards.cardlist.simple

import androidx.annotation.DrawableRes

data class SimpleCardListData(
    val id: String, val title: String, val imageUrl: String, @DrawableRes val imageRes: Int? = null
)