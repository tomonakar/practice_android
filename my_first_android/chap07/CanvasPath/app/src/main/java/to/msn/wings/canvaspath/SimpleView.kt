package to.msn.wings.canvaspath

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs)  {
    private val p = Paint().apply {
        color = Color.CYAN
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }
    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)

        canvas.drawPath(
            path.apply {
                moveTo(150f, 200f)
                lineTo(800f, 500f)
                lineTo(200f, 150f)
            },
            p
        )
    }
}
