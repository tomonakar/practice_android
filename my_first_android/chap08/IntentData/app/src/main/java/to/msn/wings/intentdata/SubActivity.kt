package to.msn.wings.intentdata

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val txtName = intent.getStringExtra("txtName")
        Toast.makeText(
            this, "こんにちは、${txtName}さん！",
            Toast.LENGTH_SHORT
        ).show()

        val btn = findViewById<Button>(R.id.btnBack)
        btn.setOnClickListener {
            finish()
        }
    }
}