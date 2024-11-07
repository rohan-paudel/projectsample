package com.gorkhacloud.projectsample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorkhacloud.projectsample.ui.theme.ProjectSampleTheme
import com.gorkhacloud.uicomponent.bottomsheet.ContentBottomSheet
import com.gorkhacloud.uicomponent.bottomsheet.MaxBottomSheet
import com.gorkhacloud.uicomponent.cards.cardlist.simple.SimpleCardList
import com.gorkhacloud.uicomponent.cards.cardlist.simple.SimpleCardListData
import com.gorkhacloud.uicomponent.edittext.EditTextField
import com.gorkhacloud.uicomponent.radio.SimpleRadio
import com.gorkhacloud.uicomponent.radio.radiolist.simple.SimpleRadioList
import com.gorkhacloud.uicomponent.radio.radiolist.simple.SimpleRadioListData
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), floatingActionButton = {
                    ExtendedFloatingActionButton(text = { Text("Show bottom sheet") },
                        icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                        onClick = {
//                            showBottomSheet = true
                        })
                }) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )

//    VerticalCard(
//        "https://picsum.photos/seed/picsum/1920/1080", "Title Here and this is the long titme"
//    )
    val context = LocalContext.current
    var showBottomSheet by remember { mutableStateOf(true) }

    Column {
        SimpleCardList(items = listOf(
            SimpleCardListData(
                "1",
                "Title Here and this is the long titme",
                "https://picsum.photos/seed/picsum/1920/1080"
            ), SimpleCardListData(
                "2",
                "Title Here and this is the long titme",
                "https://picsum.photos/seed/picsum/1920/1080"
            ), SimpleCardListData(
                "3",
                "Title Here and this is the long titme",
                "https://picsum.photos/seed/picsum/1920/1080"
            ), SimpleCardListData(
                "4",
                "Title Here and this is the long titme",
                "https://picsum.photos/seed/picsum/1920/1080"
            ), SimpleCardListData(
                "5", "Title Here a", "https://picsum.photos/seed/picsum/1920/1080"
            ), SimpleCardListData(
                "6",
                "Title Here and this is the long titme",
                "https://picsum.photos/seed/picsum/1920/1080"
            )
        ), onCardClick = {
            showBottomSheet = true
        })

        if (showBottomSheet) {
            MaxBottomSheet(onDismissListener = {
                showBottomSheet = false
            }) { sheetState, scope ->
                Column {
                    Button(onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }) {
                        Text("Hide bottom sheet")
                    }

                    SimpleRadio(
                        "hey", { isSelected ->
                            Toast.makeText(context, "isSelected: $isSelected", Toast.LENGTH_SHORT)
                                .show()
                        }, modifier = Modifier.padding(12.dp)
                    )

                    SimpleRadioList(
                        items = listOf(
                            SimpleRadioListData(
                                id = "1", title = "Economy"
                            ), SimpleRadioListData(
                                id = "1", title = "Premium"
                            ), SimpleRadioListData(
                                id = "1", title = "Luxury"
                            )
                        ), selectedPosition = 2, modifier = Modifier.padding(12.dp)
                    ) { index, item ->

                    }

                    EditTextField{ }
                }

            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectSampleTheme {
        Greeting("Android")
    }
}