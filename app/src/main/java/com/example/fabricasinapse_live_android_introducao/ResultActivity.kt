package com.example.fabricasinapse_live_android_introducao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val typedName = intent.getStringExtra("TYPED_NAME")
        val tvResult= findViewById<TextView>(R.id.tvResult)
        tvResult.text = typedName
    }
}