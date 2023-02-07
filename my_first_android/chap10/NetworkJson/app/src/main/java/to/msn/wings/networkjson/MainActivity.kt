package to.msn.wings.networkjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    @WorkerThread
    private suspend fun processBackground(): String {
        return withContext(Dispatchers.IO) {
            val result = StringBuilder()
            val url = URL("https://wings.msn.to/tmp/it/books.json")
            val con = url.openConnection() as HttpURLConnection
            con.requestMethod = "GET"
            val reader = con.inputStream.bufferedReader()
            reader.forEachLine {
                result.append(it)
            }
            val list = StringBuilder()
            val json = JSONObject(result.toString())
            val books = json.getJSONArray("books")
            for (i in 0 until books.length()) {
                val book = books.getJSONObject(i)
                list.append(book.getString("title")).append("／")
                list.append(book.getString("price")).append("円\n")
            }
            list.toString()
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
    }
}