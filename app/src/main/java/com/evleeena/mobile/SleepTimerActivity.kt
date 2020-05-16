package com.evleeena.mobile

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class SleepTimerActivity : AppCompatActivity() {

    private var mChronometer: Chronometer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_timer)
        mChronometer = findViewById(R.id.chronometer)

        if (savedInstanceState != null) {
            mChronometer?.base = savedInstanceState.getLong("ChronoTime")
            mChronometer?.start()
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState);
        mChronometer?.base?.let { savedInstanceState.putLong("ChronoTime", it) }
    }

    fun onStartClick(view: View) {
        mChronometer?.start()
        mChronometer?.onSaveInstanceState()
    }

    fun onResetClick(view: View) {
        mChronometer?.base = SystemClock.elapsedRealtime()
    }

    fun onStopClick(view: View) {
        mChronometer?.stop()
    }
}
