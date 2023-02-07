package to.msn.wings.sensorshake

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private lateinit var manager: SensorManager
    private lateinit var listener: SensorEventListener
    private lateinit var list: List<Sensor>
    private var bTime = 0L
    private var bValue = 0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = getSystemService(SENSOR_SERVICE) as SensorManager
        list = manager.getSensorList(Sensor.TYPE_ACCELEROMETER)
        listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                val cValue = event.values[0] + event.values[1]
                val cTime = System.currentTimeMillis()
                val diff = cTime - bTime
                if (diff > 1000) {
                    val speed = abs(cValue - bValue) / diff * 10000
                    if (speed > 30) {
                        Toast.makeText(this@MainActivity, "シェイク", Toast.LENGTH_LONG).show()
                    }
                    bValue = cValue
                    bTime = cTime
                }
            }

            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
        }
    }

    override fun onResume() {
        super.onResume()
        if (list.isNotEmpty()) {
            manager.registerListener(
                listener, list[0],
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }

    override fun onPause() {
        super.onPause()
        manager.unregisterListener(listener, list[0])
    }
}