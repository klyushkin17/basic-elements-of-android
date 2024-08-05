package com.example.basic_elements_of_android.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneMode = intent?.getBooleanExtra("state", false) ?: false
        if (isAirplaneMode) {
            Log.d("checkData", "Airplane mode enabled")
        }
        else {
            Log.d("checkData", "Airplane mode disabled")
        }
    }
}