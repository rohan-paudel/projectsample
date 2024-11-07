package com.gorkhacloud.uicomponent.bottomsheet

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentBottomSheet(
    modifier: Modifier = Modifier,
    onDismissListener: () -> Unit = {},
    content: @Composable (SheetState, CoroutineScope) -> Unit= {SheetState, CoroutineScope ->}
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismissListener,
        sheetState = sheetState,
        modifier = modifier
    ) {
        content(sheetState, scope)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaxBottomSheet(
    modifier: Modifier = Modifier,
    shouldStopAtMiddle: Boolean = true,
    onDismissListener: () -> Unit = {},
    content: @Composable (SheetState, CoroutineScope) -> Unit = {SheetState, CoroutineScope ->}
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = !shouldStopAtMiddle
    )
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismissListener,
        sheetState = sheetState,
        modifier = modifier.fillMaxHeight()
    ) {
        content(sheetState, scope)
    }
}



//    ) {
////            Button(onClick = {
////                scope.launch { sheetState.hide() }.invokeOnCompletion {
////                    if (!sheetState.isVisible) {
////                        showBottomSheetState.value = false
////                    }
////                }
////            }) {
////                Text("Hide bottom sheet")
////            }
//
//        content(sheetState, scope)
//
//    }