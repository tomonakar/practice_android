package to.msn.wings.servicetimer

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class SimpleService : Service() {
    companion object {
        private const val TAG = "SimpleService"
    }
    private lateinit var schedule: ScheduledExecutorService
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        schedule = Executors.newSingleThreadScheduledExecutor()
        schedule.scheduleAtFixedRate(
            {
                Log.i(TAG, "onStartCommand")
            },
            0, 1000, TimeUnit.MILLISECONDS
        )
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
        schedule.shutdown()
    }
}