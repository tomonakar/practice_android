package to.msn.wings.networkbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.os.HandlerCompat
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = StringBuilder()
        Executors.newSingleThreadExecutor().execute {
            val url = URL("https://wings.msn.to/")
            val con = url.openConnection() as HttpURLConnection
            con.requestMethod = "GET"
            val reader = con.inputStream.bufferedReader()
            reader.forEachLine {
                result.append(it)
            }
            HandlerCompat.createAsync(mainLooper).post {
                findViewById<TextView>(R.id.txtResult).text = result.toString()
            }
        }
        /*
        val url = URL("https://wings.msn.to/")
        val con = url.openConnection() as HttpURLConnection
        con.requestMethod = "GET"
        val reader = con.inputStream.bufferedReader()
        val builder = StringBuilder()
        reader.forEachLine {
            builder.append(it)
        }
        val txtResult = findViewById<TextView>(R.id.txtResult)
        txtResult.text = builder.toString()
        */

    }
}