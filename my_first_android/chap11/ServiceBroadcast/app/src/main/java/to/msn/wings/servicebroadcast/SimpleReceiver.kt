package to.msn.wings.servicebroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SimpleReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(
            context,
            "現在時刻：${intent.getStringExtra("message")}",
            Toast.LENGTH_SHORT
        ).show()
    }
}