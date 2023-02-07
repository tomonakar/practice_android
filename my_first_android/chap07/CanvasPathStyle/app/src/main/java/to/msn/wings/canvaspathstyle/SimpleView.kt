package to.msn.wings.canvaspathstyle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val p = Paint().apply {
        color = Color.CYAN
        strokeWidth = 30f
        style = Paint.Style.STROKE
    }
    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)

        canvas.drawPath(
            path.apply {
                moveTo(210f, 300f)
                lineTo(240f, 650f)
                lineTo(270f, 300f)
            },
            p.apply {
                strokeJoin = Paint.Join.BEVEL
            }
        )

        canvas.drawPath(
            path.apply {
                reset()
                moveTo(400f, 300f)
                lineTo(440f, 650f)
                lineTo(470f, 300f)
            },
            p.apply {
                strokeMiter = 30f
                strokeJoin = Paint.Join.MITER
            }
        )

        canvas.drawPath(
            path.apply {
                reset()
                moveTo(600f, 300f)
                lineTo(640f, 650f)
                lineTo(670f, 300f)
            },
            p.apply {
                strokeJoin = Paint.Join.ROUND
            }
        )
    }
}