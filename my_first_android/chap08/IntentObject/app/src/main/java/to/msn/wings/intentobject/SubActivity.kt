package to.msn.wings.intentobject

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val b = intent.getSerializableExtra("app") as Book
        Toast.makeText(this,
            b.toString(),
            Toast.LENGTH_LONG).show()

        val btn = findViewById<Button>(R.id.btnBack)
        btn.setOnClickListener {
            finish()
        }
    }
}