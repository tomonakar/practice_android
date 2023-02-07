package to.msn.wings.canvaslines

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val p = Paint().apply {
        color = Color.CYAN
        strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.WHITE)
        canvas.drawLines(
            floatArrayOf(50f, 100f, 350f, 350f, 350f, 350f, 575f,
                100f, 575f, 100f, 720f, 350f, 720f, 350f, 900f, 100f), p)
    }
}