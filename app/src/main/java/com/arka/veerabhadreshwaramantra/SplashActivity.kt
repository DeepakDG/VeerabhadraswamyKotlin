package com.arka.veerabhadreshwaramantra

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val splashTimeOut: Long = 3000 // 1 sec

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        if (supportActionBar != null) {
            supportActionBar?.hide()
        }

        val textView = findViewById<TextView>(R.id.splash_textview)
        textView.setText(R.string.app_name)
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        //starting the animation
        textView.startAnimation(animation)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            startActivity(Intent(this, MainActivity::class.java))
            // close this activity
            finish()
        }, splashTimeOut)
    }
}