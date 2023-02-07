package to.msn.wings.intentbasic

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        Log.d("LIFE", "sub_onCreate")

        val btn = findViewById<Button>(R.id.btnBack)
        btn.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFE", "sub_onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFE", "sub_onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFE", "sub_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFE", "sub_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFE", "sub_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFE", "sub_onDestroy")
    }
}