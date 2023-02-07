package to.msn.wings.gesturedetector

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var gd: GestureDetector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gd = GestureDetector(this,
            object : SimpleOnGestureListener() {
                override fun onDoubleTap(e: MotionEvent): Boolean {
                    Log.d("Gesture", "DoubleTap")
                    return true
                }

                override fun onDoubleTapEvent(e: MotionEvent): Boolean {
                    Log.d("Gesture", "DoubleTapEvent")
                    return super.onDoubleTapEvent(e)
                }

                override fun onDown(e: MotionEvent): Boolean {
                    Log.d("Gesture", "Down")
                    return true
                }

                override fun onFling(
                    e1: MotionEvent, e2: MotionEvent,
                    velocityX: Float, velocityY: Float
                ): Boolean {
                    Log.d("Gesture", "Fling")
                    return true
                }

                override fun onLongPress(e: MotionEvent) {
                    Log.d("Gesture", "LongPress")
                    super.onLongPress(e)
                }

                override fun onScroll(
                    e1: MotionEvent, e2: MotionEvent,
                    distanceX: Float, distanceY: Float
                ): Boolean {
                    Log.d("Gesture", "Scroll")
                    return true
                }

                override fun onShowPress(e: MotionEvent) {
                    Log.d("Gesture", "ShowPress")
                }

                override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                    Log.d("Gesture", "SingleTapConfirmed")
                    return true
                }

                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    Log.d("Gesture", "SingleTapUp")
                    return true
                }
            }
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gd.onTouchEvent(event)
        return true
    }
}