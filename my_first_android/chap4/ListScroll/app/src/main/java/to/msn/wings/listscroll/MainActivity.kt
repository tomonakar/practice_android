package to.msn.wings.listscroll

import android.os.Bundle
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf("胡椒", "ターメリック",
            "コリアンダー", "生姜", "ニンニク", "サフラン",
            "オレガノ", "クミン", "クローブ", "シナモン",
            "ナツメグ", "セージ", "タイム", "パクチー",
            "カモミール", "バジル", "パプリカ", "マスタード",
            "レモングラス", "ローズマリー")

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, data
        )
        val list = findViewById<ListView>(R.id.list)
        list.adapter = adapter
        // list.setSelection(5)

        list.setOnScrollListener(
            object : AbsListView.OnScrollListener {
                override fun onScroll(av: AbsListView, firstVisibleItem: Int,
                                      visibleItemCount: Int, totalItemCount: Int) {
                    if (firstVisibleItem + visibleItemCount + 3 > totalItemCount) {
                        adapter.add("新 胡椒")
                        adapter.add("新 ターメリック")
                        adapter.add("新 コリアンダー")
                    }
                }
                override fun onScrollStateChanged(arg0: AbsListView, arg1: Int) {}
            }
        )
    }
}