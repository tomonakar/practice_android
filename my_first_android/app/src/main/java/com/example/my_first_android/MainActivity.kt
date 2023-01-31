package com.example.my_first_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.my_first_android.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /**
     * ViewBindingで定義
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCurrent.setOnClickListener {
            binding.txtResult.text = Date().toString()
        }
    }



//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val btnCurrent = findViewById<Button>(R.id.btnCurrent)
//        /**
//         * ラムダ式で定義
//         */
//        btnCurrent.setOnClickListener {
//            val txtResult = findViewById<TextView>(R.id.txtResult)
//            txtResult.text = Date().toString()
//        }
//    }

    /**
     * 愚直にリスナークラスを定義
     */
//    private inner class MyListener: View.OnClickListener {
//        override fun onClick(p0: View?) {
//            val txtResult = findViewById<TextView>(R.id.txtResult)
//            txtResult.text = Date().toString()
//        }
//    }

    /**
     * リスナークラスを利用
     */
 // btnCurrent.setOnClickListener(MyListener())

    /**
     * オブジェクト式で定義した場合
     */
//        btnCurrent.setOnClickListener(
//            // オブジェクト式
//            object: View.OnClickListener {
//                override fun onClick(p0: View?) {
//                    val txtResult = findViewById<TextView>(R.id.txtResult)
//                    txtResult.text = Date().toString()
//                }
//            }
//        )


    /**
     * view側にイベント名を定義した場合
     */
//    fun btnCurrentClick(v: View) {
//        val txtResult = findViewById<TextView>(R.id.txtResult)
//        println(v)
//        txtResult.text = Date().toString()
//    }
}