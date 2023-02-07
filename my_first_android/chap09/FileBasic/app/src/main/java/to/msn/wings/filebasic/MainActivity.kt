package to.msn.wings.filebasic

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.lang.StringBuilder
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val str = StringBuilder()

        // memo.datからの読み込み
        openFileInput("memo.dat")
        .bufferedReader().forEachLine {
            str.append(it)
            str.append(System.getProperty("line.separator"))
        }

        /*
        File(filesDir, "memo.dat").forEachLine {
            str.append(it)
            str.append(System.getProperty("line.separator"))
        }
        */

        val txtMemo = findViewById<EditText>(R.id.txtMemo)
        txtMemo.setText(str.toString())
        val btn = findViewById<Button>(R.id.btnSave)
        btn.setOnClickListener {
            openFileOutput("memo.dat", MODE_PRIVATE)
            .bufferedWriter().use {
                it.write(txtMemo.text.toString())
            }

            /*
            File(filesDir, "memo.dat")
                .writeText(txtMemo.text.toString())
            */
        }
    }
}