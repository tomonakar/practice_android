package to.msn.wings.preferencecustom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MyConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, MyConfigFragment())
            .commit()
    }
}
