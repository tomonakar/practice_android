package to.msn.wings.themebasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setTheme(R.style.Theme_MaterialComponents)
        setContentView(R.layout.activity_main)
    }
}