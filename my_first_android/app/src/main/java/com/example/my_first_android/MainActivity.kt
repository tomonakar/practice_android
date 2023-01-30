package com.example.my_first_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCurrent = findViewById<Button>(R.id.btnCurrent)
        btnCurrent.setOnClickListener(
            object: View.OnClickListener {
                override fun onClick(p0: View?) {
                    val txtResult = findViewById<TextView>(R.id.txtResult)
                    txtResult.text = Date().toString()
                }
            }
        )
    }
//    fun btnCurrentClick(v: View) {
//        val txtResult = findViewById<TextView>(R.id.txtResult)
//        println(v)
//        txtResult.text = Date().toString()
//    }
}