package to.msn.wings.servicebasic

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SimpleService : Service() {
    companion object {
        private const val TAG = "SimpleService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand")
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }
}