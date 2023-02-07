package to.msn.wings.intentforresult

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val btn = findViewById<Button>(R.id.btnBack)
        btn.setOnClickListener {
            val txtName = findViewById<EditText>(R.id.txtName)
            setResult(
                RESULT_OK,
                Intent().apply {
                    putExtra("txtName", txtName.text.toString())
                }
            )
            finish()
        }
    }
}