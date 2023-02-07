package to.msn.wings.listsearch

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = arrayOf("胡椒", "ターメリック",
            "コリアンダー", "生姜", "ニンニク", "サフラン",
            "オレガノ", "クミン", "クローブ", "シナモン",
            "ナツメグ", "セージ", "タイム", "パクチー",
            "カモミール", "バジル", "パプリカ", "マスタード",
            "レモングラス", "ローズマリー")

        val list = findViewById<ListView>(R.id.list)
        list.adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, data
        )
        list.isTextFilterEnabled = true

        val sv = findViewById<SearchView>(R.id.search)
        // sv.isSubmitButtonEnabled = true
        sv.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(text: String?): Boolean {
                    if (text.isNullOrBlank()) {
                        list.clearTextFilter()
                    } else {
                        list.setFilterText(text)
                    }
                    return false
                }

                override fun onQueryTextSubmit(arg0: String?): Boolean {
                    return false
                }
            }
        )
    }
}