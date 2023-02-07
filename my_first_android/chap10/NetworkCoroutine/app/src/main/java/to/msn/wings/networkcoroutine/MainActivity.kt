package to.msn.wings.networkcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    @WorkerThread
    private suspend fun processBackground(): String {
        return withContext(Dispatchers.IO) {
            val result = StringBuilder()
            val url = URL("https://wings.msn.to/")
            val con = url.openConnection() as HttpURLConnection
            con.requestMethod = "GET"
            val reader = con.inputStream.bufferedReader()
            reader.forEachLine {
                result.append(it)
            }
            result.toString()
        }
    }

    @UiThread
    private fun postBackground(result: String) {
        findViewById<TextView>(R.id.txtResult).text = result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            val result = processBackground()
            postBackground(result)
        }
        findViewById<TextView>(R.id.txtResult).text = "...通信中..."
    }
}