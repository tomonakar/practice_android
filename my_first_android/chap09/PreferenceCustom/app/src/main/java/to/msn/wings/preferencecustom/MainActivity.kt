package to.msn.wings.preferencecustom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val msg = "News購読：${pref.getBoolean("chk", true)}"
        // val msg = "News購読：${pref.getBoolean("switch", true)}"
        // val msg = "血液型：${pref.getString("list", "A型")}"
        // val msg = "OS：${pref.getStringSet("multi", setOf(""))?.joinToString()}"

        /*
        val msg = """
            ユーザー名：${pref.getString("edittext_name", "なし")}
            血液型：${pref.getString("list", "A型")}
            News購読：${pref.getBoolean("chk", true)}
        """.trimIndent()
        */

        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()

        findViewById<Button>(R.id.btn).setOnClickListener {
            startActivity(
                Intent(this@MainActivity, MyConfigActivity::class.java)
            )
        }
    }
}