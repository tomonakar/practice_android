package to.msn.wings.canvascircle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val p = Paint().apply {
        color = Color.CYAN
        strokeWidth = 20f
        style = Paint.Style.FILL_AND_STROKE
    }
    private val rectf = RectF(200f, 400f, 800f, 800f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.WHITE)
        canvas.drawCircle(200f, 200f, 100f, p)
        canvas.drawOval(rectf, p)
    }
}