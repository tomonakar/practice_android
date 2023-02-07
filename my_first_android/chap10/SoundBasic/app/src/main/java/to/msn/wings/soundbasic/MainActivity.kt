package to.msn.wings.soundbasic

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var  btn: Button
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mp = MediaPlayer.create(this, R.raw.sound)
        mp.setOnCompletionListener { btn.text = "再生" }

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