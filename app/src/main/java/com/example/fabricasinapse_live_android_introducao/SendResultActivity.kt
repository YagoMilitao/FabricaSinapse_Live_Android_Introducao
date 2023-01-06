package com.example.fabricasinapse_live_android_introducao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SendResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_result)

        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        
    }
}