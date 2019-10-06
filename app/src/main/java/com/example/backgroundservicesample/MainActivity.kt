package com.example.backgroundservicesample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        bt_start.setOnClickListener {
            onStartService()
        }

        bt_stop.setOnClickListener {
            onStopService()
        }
    }

    private fun onStopService() {
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
        progressBar.visibility = View.INVISIBLE
    }

    private fun onStartService() {
        val intent = Intent(this, MyService::class.java)
        startService(intent)
        progressBar.visibility = View.VISIBLE

    }
}
