package to.msn.wings.canvasarc

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
        strokeWidth = 5f
        style = Paint.Style.FILL_AND_STROKE
    }
    private val rectf = RectF(300f, 200f, 800f, 700f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.WHITE)
        canvas.drawArc(rectf, 90f, 150f, true, p)
    }
}