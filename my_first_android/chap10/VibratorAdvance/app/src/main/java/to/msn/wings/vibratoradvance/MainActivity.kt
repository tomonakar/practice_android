package to.msn.wings.vibratoradvance

import android.os.Bundle
import android.os.VibrationEffect
import android.os.VibrationEffect.DEFAULT_AMPLITUDE
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val v = getSystemService(VIBRATOR_SERVICE) as Vibrator
        v.vibrate(VibrationEffect.createOneShot(100, DEFAULT_AMPLITUDE))
        v.vibrate(
            VibrationEffect.createWaveform(
                longArrayOf(1000, 500, 1000, 500, 2000, 500),
                intArrayOf(
                    0, DEFAULT_AMPLITUDE,
                    0, DEFAULT_AMPLITUDE,
                    0, DEFAULT_AMPLITUDE
                ),
                -1)
        )
    }
}