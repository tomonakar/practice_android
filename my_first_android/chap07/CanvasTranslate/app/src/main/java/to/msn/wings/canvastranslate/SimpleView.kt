package to.msn.wings.canvastranslate

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val p = Paint().apply {
        color = Color.CYAN
        strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.WHITE)
        canvas.translate(200f, 200f)
        canvas.scale(1.5f, 1.5f)
        canvas.rotate(60f)
        canvas.drawRect(0f, 0f, 200f, 200f, p)

        /*
        //座標軸に傾きを持たせる
        canvas.skew(-0.1f, 0.5f)
        canvas.drawRect(200f, 200f, 500f, 500f, p)
        */

        /*
        //座標情報を保存／リストアする
        canvas.save()
        canvas.translate(400f, 400f)
        canvas.drawRect(0f, 0f, 300f, 300f, p)
        canvas.restore()
        canvas.drawRect(0f, 0f, 300f, 300f, p)
        */
    }
}