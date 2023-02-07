package to.msn.wings.servicestatus

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class SimpleService : Service() {
    companion object {
        private const val TAG = "SimpleService"
        private const val NOTIFY_ID = 0
    }
    private lateinit var  manager: NotificationManager
    private lateinit var  channel: NotificationChannel
    private lateinit var schedule: ScheduledExecutorService
    override fun onCreate() {
        super.onCreate()
        channel = NotificationChannel(
            "service_status", "サービス状況",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            vibrationPattern = longArrayOf(1000, 500, 1000, 500, 2000, 500)
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val notif = NotificationCompat.Builder(this, "service_status")
            .setContentTitle("SimpleService")
            .setContentText("サービスは起動中です。")
            .setSmallIcon(R.drawable.wings_logo)
            .setWhen(System.currentTimeMillis())
            .setContentIntent(
                PendingIntent.getActivity(
                    this, MainActivity.ACTIVITY_ID,
                    Intent(this, MainActivity::class.java),
                    PendingIntent.FLAG_CANCEL_CURRENT
                )
            )
            .build()
        manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
        manager.notify(NOTIFY_ID, notif)

        schedule = Executors.newSingleThreadScheduledExecutor()
        schedule.scheduleAtFixedRate(
            {
                Log.i(TAG, "onStartCommand")
            },
            0,
            5000,
            TimeUnit.MILLISECONDS
        )
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        manager.cancel(NOTIFY_ID)
        Log.i(TAG, "onDestroy")
        schedule.shutdown()
    }
}