package to.msn.wings.dialogcustom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            val dialog = MyDialogFragment()
            val args = Bundle()
            val txtName = findViewById<EditText>(R.id.txtName)
            args.putString("txtName", txtName.text.toString())
            dialog.arguments = args
            dialog.show(supportFragmentManager, "dialog_custom")
        }
    }
}