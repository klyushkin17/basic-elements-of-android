package com.example.basic_elements_of_android

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.basic_elements_of_android.screens.FirstScreen
import com.example.basic_elements_of_android.screens.SecondScreen
import com.example.basic_elements_of_android.ui.theme.BasicelementsofandroidTheme

class SecondActivity: ComponentActivity() {
    companion object {
        const val ARG_EXAMPLE = "Some text"

        fun newIntent(context: Context, someText: String) =
            Intent(context, SecondActivity::class.java).apply {
                putExtra(ARG_EXAMPLE, someText)
            }
    }
    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val someText = intent?.extras?.getString(ARG_EXAMPLE)
        Log.d("checkData", "SecondActivity: onCreate $someText")
        enableEdgeToEdge()

        receiver = com.example.basic_elements_of_android.receivers.BroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

        setContent {
            BasicelementsofandroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SecondScreen()
                    Button(onClick = {
                        // This is how we can send broadcast to another app
                        sendBroadcast(
                            Intent("TEST_ACTION")
                        )
                    }) {

                    }
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
        unregisterReceiver(receiver)
        Log.d("checkData", "SecondActivity: onDestroy")
    }
}