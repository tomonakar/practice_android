package to.msn.wings.canvaspoints

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val p = Paint().apply {
        color = Color.CYAN
        strokeWidth = 30f
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.WHITE)
        canvas.drawPoints(
            floatArrayOf(50f, 100f, 80f, 130f, 110f, 160f, 140f, 190f), p)
    }
}