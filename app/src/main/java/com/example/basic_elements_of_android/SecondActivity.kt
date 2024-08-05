package com.example.basic_elements_of_android

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.basic_elements_of_android.screens.FirstScreen
import com.example.basic_elements_of_android.screens.SecondScreen
import com.example.basic_elements_of_android.ui.theme.BasicelementsofandroidTheme

class SecondActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("checkData", "SecondActivity: onCreate")
        enableEdgeToEdge()
        setContent {
            BasicelementsofandroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SecondScreen()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("checkData", "SecondActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("checkData", "SecondActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("checkData", "SecondActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("checkData", "SecondActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("checkData", "SecondActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checkData", "SecondActivity: onDestroy")
    }
}