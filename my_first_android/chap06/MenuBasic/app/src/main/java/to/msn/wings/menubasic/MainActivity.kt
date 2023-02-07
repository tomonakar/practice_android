package to.msn.wings.menubasic

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(
            this, item.title, Toast.LENGTH_LONG).show()

        /*
        when (item.itemId) {
            R.id.item1 -> Toast.makeText(this, "menu1",Toast.LENGTH_LONG).show()
            R.id.item2 -> Toast.makeText(this, "menu2",Toast.LENGTH_LONG).show()
        }
        */

        return true
    }
}