package to.msn.wings.listcustom

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = listOf(
        mapOf("title" to "革命のエチュード", "tag" to "ピアノ",
            "desc" to "ピアノの詩人と言われたショパンの代表的なピアノ曲です。"),
        mapOf("title" to "G線上のアリア", "tag" to "バイオリン",
            "desc" to "バッハの作品。バイオリンのG線のみで演奏できることからこのタイトルで親しまれています。"),
        mapOf("title" to "シャコンヌ", "tag" to "チェロ",
            "desc" to "バッハの作品。パルティータ第2番の終曲です。"),
        mapOf("title" to "夜の女王のアリア", "tag" to "声楽",
            "desc" to "モーツァルト作曲のオペラ「魔笛」の中のアリアです。"),
        mapOf("title" to "春の海", "tag" to "箏",
            "desc" to "宮城道雄の作品です。曲の舞台は鞆の浦と言われています。")
        )

        val list = findViewById<ListView>(R.id.list)
        list.adapter = SimpleAdapter(
            this,
            data,
            R.layout.list_item,
            arrayOf("title", "tag", "desc"),
            intArrayOf(R.id.title, R.id.tag, R.id.desc)
        )
    }
}