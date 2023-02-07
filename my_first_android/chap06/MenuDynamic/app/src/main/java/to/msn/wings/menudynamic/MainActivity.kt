package to.msn.wings.menudynamic

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, 0, 0, "ホーム").setIcon(R.drawable.menu1)
        // menu.add(0, 0, 0, R.string.str).setIcon(R.drawable.menu1)
        val sm1 = menu.addSubMenu(0, 1, 1, "ヘルプ")
            .setIcon(R.drawable.menu2)
        sm1.add(0, 2, 0, "検索").setIcon(R.drawable.menu3)
        sm1.add(0, 3, 1, "インポート").setIcon(R.drawable.menu4)
        sm1.add(0, 4, 2, "エクスポート").setIcon(R.drawable.menu5)
        sm1.add(0, 5, 3, "バージョン").setIcon(R.drawable.menu6)
        val sm2 = menu.addSubMenu(0, 6, 2, "設定")
            .setIcon(R.drawable.menu7)
        sm2.add(0, 7, 0, "明るさ").setIcon(R.drawable.menu8)
        sm2.add(0, 8, 1, "音量").setIcon(R.drawable.menu9)
        sm2.add(0, 9, 2, "暗証番号").setIcon(R.drawable.menu10)
        menu.add(0, 10, 3, "ごみ箱").setIcon(R.drawable.menu11)

        // menu.removeItem(0)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val toast = Toast.makeText(this, item.title, Toast.LENGTH_LONG)
        toast.show()
        return true
    }
}