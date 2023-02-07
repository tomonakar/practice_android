package to.msn.wings.intentobject

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
            val txtTitle = findViewById<EditText>(R.id.txtTitle)
            val txtPublish = findViewById<EditText>(R.id.txtPublish)
            val txtPrice = findViewById<EditText>(R.id.txtPrice)
            val b = Book(
                txtTitle.text.toString(),
                txtPublish.text.toString(),
                txtPrice.text.toString()
            )
            startActivity(
                Intent(this, SubActivity::class.java).apply {
                    putExtra("app", b)
                }
            )
        }
    }
}