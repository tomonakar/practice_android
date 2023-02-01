package com.example.my_first_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.my_first_android.databinding.ActivityMainBinding
import org.w3c.dom.Text
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
            /**
             * トーストオブジェクトの生成
             */
            val toast = Toast.makeText(this@MainActivity,
            Date().toString(),Toast.LENGTH_LONG)
            toast.show()
        }
    }

    /**
     * 画面が破棄される前に状態を保存
     */
    override fun onSaveInstanceState(outState: Bundle) {
        // 画面が破棄される時に呼び出される
        super.onSaveInstanceState(outState)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        outState.putString("txtResult", txtResult.text.toString())
    }

    /**
     * 画面が復元される前に状態を取り出し
     * Bundleはアプリの状態を key/valueの値で管理するオブジェクト
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // 画面が再生成される時に呼び出される
        super.onRestoreInstanceState(savedInstanceState)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        txtResult.text = savedInstanceState.getString("txtResult")
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