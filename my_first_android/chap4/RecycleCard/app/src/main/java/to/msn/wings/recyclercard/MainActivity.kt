package to.msn.wings.recyclercard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
            ListItem(1, "革命のエチュード", "ピアノ",
                "ピアノの詩人と言われたショパンの代表的なピアノ曲です。"),
            ListItem(2, "G線上のアリア", "バイオリン",
                "バッハの作品。バイオリンのG線のみで演奏できることからこのタイトルで親しまれています。"),
            ListItem(3, "シャコンヌ", "チェロ",
                "バッハの作品。パルティータ第2番の終曲です。"),
            ListItem(4, "夜の女王のアリア", "声楽",
                "モーツァルト作曲のオペラ「魔笛」の中のアリアです。"),
            ListItem(5, "春の海", "箏",
                "宮城道雄の作品です。曲の舞台は鞆の浦と言われています。")
        )
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.setHasFixedSize(true)
        rv.layoutManager= LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        // val manager = GridLayoutManager(this, 2)
        // rv.layoutManager = manager
        rv.adapter = MyListAdapter(data)
    }
}