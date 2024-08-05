package com.example.basic_elements_of_android.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CountService: Service(){
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service has been started", Toast.LENGTH_LONG).show()
        startCount()
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {
        Toast.makeText(this, "Service has been stopped", Toast.LENGTH_LONG).show()
    }

    private fun startCount() {
        GlobalScope.launch {
            for (i in 0 until 20) {
                Log.d("checkData", "Service::: Count $i")
                delay(1000L)
                if (i == 19) {
                    stopSelf()
                }
            }
        }
    }
}