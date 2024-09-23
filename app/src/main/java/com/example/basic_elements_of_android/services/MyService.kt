package com.example.basic_elements_of_android.services

import android.app.Service
import android.content.Intent
import android.os.IBinder


class MyService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return calculator
    }

    private val calculator = object: ICalculator.Stub() {

        override fun add(a: Int, b: Int): Int {
            ProcessHelper.logProcessName(this)
            ProcessHelper.logThreadName(this)
            return a + b
        }
    }
}