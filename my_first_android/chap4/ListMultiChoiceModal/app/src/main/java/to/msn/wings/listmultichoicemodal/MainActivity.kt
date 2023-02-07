package to.msn.wings.listmultichoicemodal

import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView.MultiChoiceModeListener
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
            this, android.R.layout.simple_list_item_checked, data
        )
        list.setMultiChoiceModeListener(object : MultiChoiceModeListener {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return true
            }

            override fun onItemCheckedStateChanged(
                mode: ActionMode?,
                position: Int,
                id: Long,
                checked: Boolean
            ) {
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return true
            }
            
            override fun onDestroyActionMode(mode: ActionMode?) {
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
        })
    }
}