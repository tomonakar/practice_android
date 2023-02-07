package to.msn.wings.surfacetouch

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class SimpleSurface(context: Context, attrs: AttributeSet) : SurfaceView(context, attrs) {
    private val path = Path()
    private val p = Paint().apply {
        color = Color.BLUE
        strokeWidth = 3f
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        holder.addCallback(
            object : SurfaceHolder.Callback {
                override fun surfaceChanged(
                    holder: SurfaceHolder, format: Int, width: Int,
                    height: Int
                ) {}

                override fun surfaceCreated(holder: SurfaceHolder) {
                    draw(holder)
                }

                override fun surfaceDestroyed(holder: SurfaceHolder) {}
            }
        )
    }

    private fun draw(holder: SurfaceHolder) {
        val canvas = holder.lockCanvas().apply {
            drawColor(Color.WHITE)
            drawPath(path, p)
        }
        holder.unlockCanvasAndPost(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(event.x, event.y)
            MotionEvent.ACTION_MOVE -> path.lineTo(event.x, event.y)
            MotionEvent.ACTION_UP -> {
                performClick()
                path.lineTo(event.x, event.y)
            }
        }
        draw(holder)
        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
}