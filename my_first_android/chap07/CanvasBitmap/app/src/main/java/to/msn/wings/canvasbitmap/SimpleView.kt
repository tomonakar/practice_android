package to.msn.wings.canvasbitmap

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

// import android.graphics.Rect
// import android.graphics.RectF

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val bmp = BitmapFactory.decodeResource(resources, R.drawable.ham)
    private val p = Paint()
    // private val rect = Rect(350, 100, 750, 500)
    // private val rectf = RectF(50f, 50f, 850f, 850f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)
        canvas.drawBitmap(bmp, 0f, 10f, p)
        // canvas.drawBitmap(bmp, rect, rectf, p)
    }
}