package com.example.blinkitclone

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OrderPlacedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placed)

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            finish()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 3000)
    }
}