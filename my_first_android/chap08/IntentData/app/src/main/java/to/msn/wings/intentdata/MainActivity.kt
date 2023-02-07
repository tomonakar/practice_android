package to.msn.wings.intentdata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnSend)
        btn.setOnClickListener {
            val txtName = findViewById<EditText>(R.id.txtName)
            startActivity(
                Intent(this, SubActivity::class.java).apply {
                    putExtra("txtName", txtName.text.toString())
                }
            )
        }
    }
}