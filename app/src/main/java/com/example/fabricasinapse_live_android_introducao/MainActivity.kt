package com.example.fabricasinapse_live_android_introducao

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var activityResultLauncher: ActivityResultLauncher<*>

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etName = findViewById<EditText>(R.id.etName)
        val btSend = findViewById<Button>(R.id.btSend)
        val btSend2 = findViewById<Button>(R.id.btSend2)
        val btSend3 = findViewById<Button>(R.id.btSend3)

        btSend.setOnClickListener {
            if (etName.text.isNullOrBlank()) {
                etName.error = getString(R.string.type_your_name)
            } else {
                tvResult.text = getString(R.string.hello_name, etName.text.toString())
            }

        }

        btSend2.setOnClickListener {
            if (etName.text.isNullOrBlank()) {
                etName.error = getString(R.string.type_your_name)
            } else {
                val typedName = etName.text.toString()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("TYPED_NAME", typedName)
                startActivity(intent)
            }

        }

        /*fun openActivityForResult() {
            startForResult.launch(Intent(this, AnotherActivity::class.java))
        }

        val getAction = registerForActivityResult(ActivityResultContract.StartActivityOnResult()){
            val result = data.getStringExtra("RESULT")
            tvResult.text = result
        }*/

        btSend3.setOnClickListener {
            val intent = Intent(this, SendResultActivity::class.java)

            val requestCode = 1


            startActivityForResult(intent, requestCode)






        }

        fun onActivityResult(requestCode: Int, result: ActivityResult, resultCode: Int, data: Intent?) {
            if(requestCode == 1) {
                if (result.resultCode == Activity.RESULT_OK && data != null) {
                    val results = data?.getStringExtra("RESULT")
                    val tvResult = findViewById<TextView>(R.id.tvResult)
                    tvResult.text = getString(R.string.data_received, results)
                } else if (result.resultCode == Activity.RESULT_CANCELED){
                    val tvResult = findViewById<TextView>(R.id.tvResult)
                    tvResult.text = getString(R.string.activity_was_canceled)
                }

            }
        }
        /*fun onActivityResult(requestCode: Int, result: ActivityResult) {
            if(result.resultCode == Activity.RESULT_OK && requestCode == 1) {
                val result = result.data?.getStringExtra("RESULT")
                val tvResult = findViewById<TextView>(R.id.tvResult)
                tvResult.text = result

            }*/

        /*fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null){
                val result = data.getStringExtra("RESULT")


            }
        }*/
    }

}
