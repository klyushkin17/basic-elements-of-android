package com.example.basic_elements_of_android.screens

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.basic_elements_of_android.SecondActivity

@Composable
fun FirstScreen() {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Screen")
        Button(onClick = {
            val intent1 = Intent(context, SecondActivity::class.java)
            context.startActivity(intent1)
        }) {
            Text(text = "Go to Second Screen")
        }
    }
}