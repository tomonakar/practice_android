package to.msn.wings.vibratorbasic

import android.os.Bundle
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val v = getSystemService(VIBRATOR_SERVICE) as Vibrator
        v.vibrate(100)
         v.vibrate(longArrayOf(1000, 500, 1000, 500, 2000, 500), -1)
    }
}