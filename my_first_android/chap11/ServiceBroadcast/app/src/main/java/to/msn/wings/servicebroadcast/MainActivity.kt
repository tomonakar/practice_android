package to.msn.wings.servicebroadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(
            SimpleReceiver(),
            IntentFilter().apply {
                addAction(SimpleService.ACTION)
            }
        )

        val btnStart = findViewById<Button>(R.id.btnStart)
        val i = Intent(this, SimpleService::class.java)
        btnStart.setOnClickListener {
            startService(i)
        }

        val btnStop = findViewById<Button>(R.id.btnStop)
        btnStop.setOnClickListener {
            stopService(i)
        }
    }
}