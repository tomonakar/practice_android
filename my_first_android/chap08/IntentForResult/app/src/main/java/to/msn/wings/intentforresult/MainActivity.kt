package to.msn.wings.intentforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startForResult = registerForActivityResult(
            StartActivityForResult()) { result ->
            if (result?.resultCode == RESULT_OK) {
                result.data?.let {
                    Toast.makeText(
                        this@MainActivity,
                        "こんにちは、${it.getStringExtra("txtName")}さん！",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }

        val btn = findViewById<Button>(R.id.btnSend)
        btn.setOnClickListener {
            startForResult.launch(Intent(this, SubActivity::class.java))
        }
    }
}