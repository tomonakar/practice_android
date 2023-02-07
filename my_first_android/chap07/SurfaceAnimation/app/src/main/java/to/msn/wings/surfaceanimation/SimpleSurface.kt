package to.msn.wings.surfaceanimation

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.concurrent.Executors

class SimpleSurface(context: Context, attrs: AttributeSet)
    : SurfaceView(context, attrs)  {
    private val service = Executors.newSingleThreadExecutor()
    private val p = Paint().apply {
        color = Color.BLUE
        holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(
                holder: SurfaceHolder, format: Int, width: Int,
                height: Int
            ) {}

            override fun surfaceCreated(holder: SurfaceHolder) {
                draw(holder)
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                this@SimpleSurface.service.shutdown()
            }
        })
    }

    private fun draw(holder: SurfaceHolder) {
        service.execute {
            for (i in 0..999) {
                val canvas = holder.lockCanvas().apply{
                    drawColor(Color.WHITE)
                    drawCircle((100 + i).toFloat(), (100 + i).toFloat(), 50f, p)
                }
                holder.unlockCanvasAndPost(canvas)
                try {
                    Thread.sleep(50)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
}