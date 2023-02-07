package to.msn.wings.networkpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.PrintStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    @WorkerThread
    private suspend fun processBackground(): String {
        return withContext(Dispatchers.IO) {
            val result = StringBuilder()
            val url = URL("https://wings.msn.to/tmp/it/sample.php")
            val con = (url.openConnection() as HttpURLConnection).apply {
                requestMethod = "POST"
                setRequestProperty("Content-Type", "text/plain; charset=utf-8")
                doOutput = true
            }
            val ps = PrintStream(con.outputStream)
            ps.print("山田太郎")
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
    }
}