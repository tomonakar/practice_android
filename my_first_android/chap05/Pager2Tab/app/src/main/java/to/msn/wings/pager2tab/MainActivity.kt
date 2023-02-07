package to.msn.wings.pager2tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
            ListItem(
                title = "散歩中のゾウの親子",
                shortTitle = "ゾウ",
                icon = ContextCompat.getDrawable(this, R.drawable.tab_icon1),
                photo = ContextCompat.getDrawable(this, R.drawable.elephant)
            ),
            ListItem(
                title = "我が家のペット",
                shortTitle = "ハムスター",
                icon = ContextCompat.getDrawable(this, R.drawable.tab_icon2),
                photo = ContextCompat.getDrawable(this, R.drawable.pet)
            ),
            ListItem(
                title = "手を振ってくれるアザラシ",
                shortTitle = "アザラシ",
                icon = ContextCompat.getDrawable(this, R.drawable.tab_icon3),
                photo = ContextCompat.getDrawable(this, R.drawable.seal)
            )
        )
        val tabs = findViewById<TabLayout>(R.id.tabs)
        val pager = findViewById<ViewPager2>(R.id.pager)
        pager.adapter = MyListAdapter(data)
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.apply {
                text = data[position].shortTitle
                contentDescription = "Page ${position + 1}"
                icon = data[position].icon
            }
        }.attach()
    }
}