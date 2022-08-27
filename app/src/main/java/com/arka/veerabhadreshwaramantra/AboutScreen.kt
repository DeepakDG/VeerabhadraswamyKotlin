package com.arka.veerabhadreshwaramantra

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aboutscreen)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "ಅಪ್ಲಿಕೇಶನ್ ಬಗ್ಗೆ"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}