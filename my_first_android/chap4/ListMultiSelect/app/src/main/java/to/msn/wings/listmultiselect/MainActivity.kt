package to.msn.wings.listmultiselect

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckedTextView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = arrayOf("胡椒", "ターメリック",
            "コリアンダー", "生姜", "ニンニク", "サフラン")
        val list = findViewById<ListView>(R.id.list)
        list.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_multiple_choice, data
        )
        list.setOnItemClickListener { av, view, position, id ->
            val msg = mutableListOf<CharSequence>()
            list.forEach {
                val check = it as CheckedTextView
                if (check.isChecked) msg.add(check.text)
            }
            Toast.makeText(
                this@MainActivity,
                "選択したのは、${msg.joinToString()}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}