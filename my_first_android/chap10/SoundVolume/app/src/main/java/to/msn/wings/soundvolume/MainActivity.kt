package to.msn.wings.soundvolume

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var am: AudioManager
    private lateinit var mp: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mp = MediaPlayer.create(this, R.raw.sound)
        mp.setOnCompletionListener { btn.text = "再生" }
        am = getSystemService(AUDIO_SERVICE) as AudioManager
        am.setStreamVolume(AudioManager.STREAM_MUSIC, 5, 0)

        val sb = findViewById<SeekBar>(R.id.seek)
        sb.setOnSeekBarChangeListener(
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    sb: SeekBar, progress: Int,
                    fromUser: Boolean
                ) {
                    am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
                }

                override fun onStartTrackingTouch(sb: SeekBar) {}
                override fun onStopTrackingTouch(sb: SeekBar) {}
            }
        )

        val btn = findViewById<Button>(R.id.btnPlay)
        btn.setOnClickListener {
            if (!mp.isPlaying) {
                mp.start()
                btn.text = "停止"
            } else {
                try {
                    mp.stop()
                    mp.prepare()
                } catch (e: IllegalStateException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                btn.text = "再生"
            }
        }
    }
}