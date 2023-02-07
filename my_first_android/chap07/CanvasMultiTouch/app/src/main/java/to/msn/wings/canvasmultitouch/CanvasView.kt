package to.msn.wings.canvasmultitouch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CanvasView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    override fun onTouchEvent(event: MotionEvent): Boolean {
        performClick()
        for (i in 0 until event.pointerCount) {
            Log.d(
            "MultiTouch",
            "ID ${event.getPointerId(i)} > [${event.getX(i)}, ${event.getY(i)}]"
            )
        }
        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
}