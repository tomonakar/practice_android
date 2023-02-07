package to.msn.wings.listselect

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = arrayOf("胡椒", "ターメリック",
            "コリアンダー", "生姜", "ニンニク", "サフラン")

        val list = findViewById<ListView>(R.id.list)
        list.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_single_choice, data
        )
        list.setOnItemClickListener { av, view, position, id ->
            Toast.makeText(
                this@MainActivity,
                "選択したのは${(view as TextView).text}です。",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}


