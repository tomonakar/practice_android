package to.msn.wings.dialogradio

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val dialog = MyDialogFragment()
            dialog.show(supportFragmentManager, "dialog_radio")
        }
    }
}