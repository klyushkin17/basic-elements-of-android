package com.example.basic_elements_of_android.services

import android.annotation.SuppressLint
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.basic_elements_of_android.R


class RunningService: android.app.Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            Action.START.toString() -> start()
            Action.STOP.toString() -> stopSelf()

        }

        return super.onStartCommand(intent, flags, startId)
    }

    @SuppressLint("ForegroundServiceType")
    private fun start() {
        val notification = NotificationCompat.Builder(
            this,
            "running_channel"
        ).setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Run is active")
            .setContentText("Active e mae")
            .build()
        startForeground(1, notification)
    }

    enum class Action {
        START,
        STOP,
    }
}