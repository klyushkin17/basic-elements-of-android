package com.example.basic_elements_of_android

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basic_elements_of_android.receivers.BroadcastReceiver
import com.example.basic_elements_of_android.screens.FirstScreen
import com.example.basic_elements_of_android.ui.theme.BasicelementsofandroidTheme

class MainActivity : ComponentActivity() {

    private val airPlainModeReceiver = BroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(
            airPlainModeReceiver,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
        Log.d("checkData", "MainActivity: onCreate")
        enableEdgeToEdge()
        setContent {
            BasicelementsofandroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirstScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("checkData", "MainActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("checkData", "MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("checkData", "MainActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("checkData", "MainActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("checkData", "MainActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airPlainModeReceiver)
        Log.d("checkData", "MainActivity: onDestroy")
    }
}
