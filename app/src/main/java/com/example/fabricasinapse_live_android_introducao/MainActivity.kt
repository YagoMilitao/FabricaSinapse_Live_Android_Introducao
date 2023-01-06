package com.example.fabricasinapse_live_android_introducao

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etName = findViewById<EditText>(R.id.etName)
        val btSend = findViewById<Button>(R.id.btSend)

        btSend.setOnClickListener {
            if(etName.text.isNullOrBlank()){
                etName.error = getString(R.string.type_your_name)
            }
            else{
                tvResult.text = getString(R.string.hello_name, etName.text.toString())
            }

        }
    }
}