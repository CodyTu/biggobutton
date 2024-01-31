package edu.uw.ischool.ctu4.biggobutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.button)
        var count: Int = 0
        var repeat: Boolean = false

        val bobbing = AnimationUtils.loadAnimation(this, R.anim.bobbing)
        button.setOnClickListener({
            repeat = !repeat
            count ++
            if (count == 1) {
                button.setText(getString(R.string.time, count))
            } else {
                button.setText(getString(R.string.times, count))
            }
            button.setBackgroundColor(Color.argb(255, Random.nextInt(255), Random.nextInt(255), Random.nextInt(255)))
            button.setTextColor(Color.argb(255, Random.nextInt(255), Random.nextInt(255), Random.nextInt(255)))
            if (repeat) {
                button.startAnimation(bobbing)
            } else {
                button.clearAnimation()
            }
        })
    }
}