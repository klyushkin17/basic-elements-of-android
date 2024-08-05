package com.example.basic_elements_of_android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.basic_elements_of_android.screens.ContactsScreen
import com.example.basic_elements_of_android.screens.FirstScreen
import com.example.basic_elements_of_android.ui.theme.BasicelementsofandroidTheme

class ContactsActivity: ComponentActivity() {
    companion object {
        const val ARG_EXAMPLE = "Some text"

        fun newIntent(context: Context, someText: String) =
            Intent(context, SecondActivity::class.java).apply {
                putExtra(ARG_EXAMPLE, someText)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("checkData", "ContactsActivity: onCreate")
        setContent {
            BasicelementsofandroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactsScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("checkData", "ContactsActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("checkData", "ContactsActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("checkData", "ContactsActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("checkData", "ContactsActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("checkData", "ContactsActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checkData", "ContactsActivity: onDestroy")
    }
}