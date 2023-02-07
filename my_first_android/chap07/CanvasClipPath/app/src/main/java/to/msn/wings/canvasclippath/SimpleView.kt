package to.msn.wings.canvasclippath

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs)  {
    private val bmp = BitmapFactory.decodeResource(resources, R.drawable.sea)
    private val p = Paint().apply {
        strokeWidth = 5f
    }
    private val rect = RectF(100f, 100f, 1000f, 900f)
    private val path = Path().apply {
        addOval(rect, Path.Direction.CW)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)
        canvas.clipPath(path)
        canvas.drawBitmap(bmp, 0f, 0f, p)
    }
}