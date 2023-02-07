package to.msn.wings.tablecollapsed

import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnflag = findViewById<Button>(R.id.btnflag)
        btnflag.setOnClickListener {
            val tbl = findViewById<TableLayout>(R.id.tbl)
            tbl.setColumnCollapsed(1, flag)
            flag = !flag
        }
    }
}