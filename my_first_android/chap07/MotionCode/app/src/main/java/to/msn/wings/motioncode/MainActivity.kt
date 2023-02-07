package to.msn.wings.motioncode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val motion = findViewById<MotionLayout>(R.id.motion)
        findViewById<Button>(R.id.btn).setOnClickListener {
            if (motion.currentState == R.id.start) {
                motion.transitionToEnd()
            } else {
                motion.transitionToStart()
            }
        }
    }
}