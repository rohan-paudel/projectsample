package com.gorkhacloud.uicomponent.modifier

import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role

fun Modifier.noIndicationClickable(
    enabled: Boolean = true, onClickLabel: String? = null, role: Role? = null, onClick: () -> Unit
) = composed(inspectorInfo = debugInspectorInfo {
    name = "clickable"
    properties["enabled"] = enabled
    properties["onClickLabel"] = onClickLabel
    properties["role"] = role
    properties["onClick"] = onClick
}) {
    val localIndication = null
    val interactionSource = remember { MutableInteractionSource() }

    Modifier.clickable(
        enabled = enabled,
        onClickLabel = onClickLabel,
        onClick = onClick,
        role = role,
        indication = localIndication,
        interactionSource = interactionSource
    )
}

fun Modifier.noIndicationSelectable(
    selected: Boolean, enabled: Boolean = true, role: Role? = null, onClick: () -> Unit
) = composed(inspectorInfo = debugInspectorInfo {
    name = "selectable"
    properties["selected"] = selected
    properties["enabled"] = enabled
    properties["role"] = role
    properties["onClick"] = onClick
}) {
    val localIndication = null
    val interactionSource = remember { MutableInteractionSource() }
    Modifier.selectable(
        selected = selected,
        interactionSource = interactionSource,
        indication = localIndication,
        enabled = enabled,
        role = role,
        onClick = onClick
    )
}