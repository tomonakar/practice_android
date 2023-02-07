package to.msn.wings.dialogargs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtName = findViewById<EditText>(R.id.txtName)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            MyDialogFragment().apply {
                arguments = Bundle().apply {
                putString("txtName", txtName.text.toString())
            }
                show(supportFragmentManager, "dialog_basic")
            }
        }
    }
}