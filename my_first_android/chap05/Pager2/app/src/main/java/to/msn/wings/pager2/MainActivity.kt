package to.msn.wings.pager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
            ListItem(
                title = "散歩中のゾウの親子",
                photo = ContextCompat.getDrawable(this, R.drawable.elephant)
            ),
            ListItem(
                title = "我が家のペット",
                photo = ContextCompat.getDrawable(this, R.drawable.pet)
            ),
            ListItem(
                title = "手を振ってくれるアザラシ",
                photo = ContextCompat.getDrawable(this, R.drawable.seal)
            )
        )
        val pager = findViewById<ViewPager2>(R.id.pager)
        pager.adapter = MyListAdapter(data)
    }
}