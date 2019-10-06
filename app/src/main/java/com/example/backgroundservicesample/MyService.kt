package com.example.backgroundservicesample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.concurrent.Executors

class MyService : Service() {
    private val TAG = "MyService"
    private val executor = Executors.newFixedThreadPool(1)
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        someHeavyTask()
//        return START_NOT_STICKY
        return START_STICKY
//        return START_REDELIVER_INTENT
    }

    private fun someHeavyTask() {
        executor.execute(MyTask())
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? = null

    inner class MyTask : Runnable {
        override fun run() {
            (0..10).forEach {
                Thread.sleep(500)
                Log.d(TAG, "someHeavyTask $it")
            }
        }
    }

}