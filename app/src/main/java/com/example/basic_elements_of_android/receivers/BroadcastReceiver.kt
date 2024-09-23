package com.example.basic_elements_of_android.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log
import androidx.compose.ui.text.font.FontVariation

class BroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        /*val isAirplaneMode = intent?.getBooleanExtra("state", false) ?: false
        if (isAirplaneMode) {
            Log.d("checkData", "Airplane mode enabled")
        }
        else {
            Log.d("checkData", "Airplane mode disabled")
        }*/

        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isTurnedOn = Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            ) != 0
            println("Is airplain mode on? $isTurnedOn")
        }
    }
}