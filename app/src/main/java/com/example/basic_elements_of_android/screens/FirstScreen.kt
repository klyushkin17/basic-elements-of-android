package com.example.basic_elements_of_android.screens

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.basic_elements_of_android.ContactsActivity
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
            val intent2 = SecondActivity.newIntent(context, "Some text text")
            context.startActivity(intent1)
        }) {
            Text(text = "Go to Second Screen")
        }
        Button(onClick = {
            val intent2 = ContactsActivity.newIntent(context, "Some text text")
            context.startActivity(intent2)
        }) {
            Text(text = "Go to Contacts Screen")
        }
    }
}