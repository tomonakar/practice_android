package to.msn.wings.canvasattr

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var color: Int = Color.BLACK
    set(value) {
        field = value
        invalidate()
        requestLayout()
    }
    private var type: Int = 0
        set(value) {
            field = value
            invalidate()
            requestLayout()
        }
    private val p = Paint()

    init {
        context.theme.obtainStyledAttributes(
        attrs, R.styleable.SimpleView, 0, 0).apply {
            try {
                color = getColor(R.styleable.SimpleView_color, Color.BLACK)
                type = getInt(R.styleable.SimpleView_type, 0)
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        p.color = color
        p.strokeWidth = 100f
        when(type) {
            0 -> canvas.drawCircle(200f, 200f, 100f, p)
            1 -> canvas.drawRect(100f, 100f, 400f, 400f, p)
            2 -> canvas.drawLine(10f, 20f, 800f, 500f, p)
            else -> {}
        }
    }
}