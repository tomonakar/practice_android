package to.msn.wings.surfacebasic

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class SimpleSurface(context: Context, attrs: AttributeSet) : SurfaceView(context, attrs) {
    private val p = Paint().apply {
        color = Color.CYAN
    }

    init {
        holder.addCallback(
            object : SurfaceHolder.Callback {
                override fun surfaceChanged(
                    holder: SurfaceHolder,
                    format: Int, width: Int, height: Int
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
            drawRect(100f, 100f, 400f, 400f, p)
        }
        holder.unlockCanvasAndPost(canvas)
    }
}