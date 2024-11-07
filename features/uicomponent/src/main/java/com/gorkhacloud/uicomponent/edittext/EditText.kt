package com.gorkhacloud.uicomponent.edittext

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditTextField(
    initialValue: TextFieldValue = TextFieldValue(""), valueChangeListener: (TextFieldValue) -> Unit
) {
    var value by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(initialValue) }
    TextField(value, {
        value = it
        valueChangeListener(it)
    })
}

@Preview(showSystemUi = true)
@Composable
fun EditTextFieldPreview() {
    EditTextField {

    }
}