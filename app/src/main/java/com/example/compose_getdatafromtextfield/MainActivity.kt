@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.compose_getdatafromtextfield

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_getdatafromtextfield.ui.theme.ComposeGetDataFromTextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGetDataFromTextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val mContext = LocalContext.current
    var text_value by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = text_value,
            onValueChange = { text_value = it },
            placeholder = { Text("...") },
            label = { Text("Type something here") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { getData(mContext, text_value.text) },
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp,
                pressedElevation = 32.dp
            )
        ) {
            Text("Get Data")
        }
    }
}

fun getData(mContext: Context, textValue: String) {
    if (textValue.isEmpty()) {
        Toast.makeText(mContext, "Text field is empty", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(mContext, "Text: $textValue", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeGetDataFromTextFieldTheme {
        Greeting()
    }
}