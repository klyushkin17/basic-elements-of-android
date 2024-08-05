package com.example.basic_elements_of_android.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.basic_elements_of_android.SecondActivity
import com.example.basic_elements_of_android.services.CountService

@Composable
fun SecondScreen() {
    val context = LocalContext.current
    val activity = if (context is Activity) context else null
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Screen")
        Button(onClick = {
            activity?.finish()
        }) {
            Text(text = "Go to First Screen")
        }
        Button(onClick = {
            activity?.startService(Intent(context, CountService::class.java))
        }) {
            Text(text = "OnStartService")
        }
        Button(onClick = {
            activity?.stopService(Intent(context, CountService::class.java))
        }) {
            Text(text = "OnStopService")
        }
    }
}