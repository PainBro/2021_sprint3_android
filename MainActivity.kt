package com.example.clicker22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var tv_clicks: TextView
    lateinit var tv_xtraFinger: TextView
    lateinit var tv_autoClicker: TextView

    lateinit var b_click: Button
    lateinit var b_xtraFinger: Button
    lateinit var b_autoClicker: Button

    var clicks = 0.0
    var click_ammount = 1.0
    var xtraFingers = 0
    var autoClickers = 0

    lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_clicks = findViewById(R.id.tvClicks)
        tv_xtraFinger = findViewById(R.id.tvXtraFinger)
        tv_autoClicker = findViewById(R.id.tvAutoClicker)

        b_click = findViewById(R.id.bClick)
        b_xtraFinger = findViewById(R.id.bXtraFinger)
        b_autoClicker = findViewById(R.id.bAutoClicker)

        b_click.setOnClickListener{
            clicks += click_ammount
            tv_clicks.text = "Clicks: " + (Math.round(clicks)).toInt()
        }

        b_xtraFinger.setOnClickListener{
            if (clicks >= 10) {
                xtraFingers++
                click_ammount = (1 + xtraFingers).toDouble()
                clicks -= 10
                tv_clicks.text = "Clicks: " + (Math.round(clicks)).toInt()
                tv_xtraFinger.text = "Xtra Fingers: $xtraFingers"
            }
        }

        b_autoClicker.setOnClickListener{
            if (clicks >= 10) {
                autoClickers++
                clicks -= 10
                tv_clicks.text = "Clicks: " + (Math.round(clicks)).toInt()
                tv_autoClicker.text = "Xtra Fingers: $autoClickers"
            }
        }

        timer = object : CountDownTimer(60000, 1000) {
            override fun onTick(p0: Long) {
                clicks += (0.1 * autoClickers)
                tv_clicks.text = "Clicks: " + (Math.round(clicks)).toInt()
            }

            override fun onFinish() {
                timer.start()
            }
        }

        timer.start()
    }
}
