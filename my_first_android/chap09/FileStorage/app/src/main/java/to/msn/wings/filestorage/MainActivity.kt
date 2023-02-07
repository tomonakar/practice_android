package to.msn.wings.filestorage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val txtMemo = findViewById<EditText>(R.id.txtMemo)
        /*
        // アプリ起動時にファイル選択画面を起動
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.data?.let {
                    val str = StringBuilder()
                    contentResolver.openInputStream(it)
                        ?.bufferedReader()?.forEachLine {
                            str.append(it)
                            str.append(System.getProperty("line.separator"))
                        }
                    txtMemo.setText(str.toString())
                }
            }
        }.launch(
            Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TITLE, "memo.txt")
            }
        )
        */

        val startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.data?.let {
                    contentResolver.openOutputStream(it)?.
                    bufferedWriter()?.use {
                        it.write(txtMemo.text.toString())
                    }
                }
            }
        }

        btnSave.setOnClickListener {
            startForResult.launch(
                Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TITLE, "memo.txt")
                }
            )
        }
    }
}