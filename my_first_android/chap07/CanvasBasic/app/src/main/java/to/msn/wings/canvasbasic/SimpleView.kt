package to.msn.wings.canvasbasic

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val p = Paint().apply {
        color = Color.CYAN
        strokeWidth = 100f
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)
        canvas.drawPoint(100f, 100f, p)
    }
}