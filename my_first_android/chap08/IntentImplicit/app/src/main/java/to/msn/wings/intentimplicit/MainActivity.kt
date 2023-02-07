package to.msn.wings.intentimplicit

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnSend)
        btn.setOnClickListener {
            val txtKeywd = findViewById<EditText>(R.id.txtKeywd)

            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(txtKeywd.text.toString())
                )
            )


            /*
            startActivity(
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse(txtKeywd.text.toString())
                )
            )
            */

            /*
            startActivity(
                Intent(Intent.ACTION_WEB_SEARCH).apply {
                    putExtra(SearchManager.QUERY, txtKeywd.text.toString())
                }
            )
            */
        }
    }
}