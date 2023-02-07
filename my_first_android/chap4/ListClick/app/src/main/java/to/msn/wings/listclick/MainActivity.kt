package to.msn.wings.listclick

import android.os.Bundle
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf("胡椒", "ターメリック",
            "コリアンダー", "生姜", "ニンニク", "サフラン")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, data
        )
        val list = findViewById<ListView>(R.id.list)
        list.adapter = adapter

        list.setOnItemClickListener { av, view, position, id ->
            adapter.remove((view as TextView).text as String)
            // adapter.add("ナツメグ")
        }

        // 長押しイベントを検知
        /*
        list.setOnItemLongClickListener { av, view, position, id ->
            adapter.remove((view as TextView).text as String)
            false
        }
        */
    }
}