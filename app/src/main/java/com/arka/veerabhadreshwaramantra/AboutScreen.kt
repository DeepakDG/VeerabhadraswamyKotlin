package com.arka.veerabhadreshwaramantra

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
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

        val btnMailUs = findViewById<Button>(R.id.btnMailUs)
        btnMailUs.setOnClickListener { view ->
            val mIntent = Intent(Intent.ACTION_SEND)
            val addressees = arrayOf("veerabhadreshwarasamithi@gmail.com")
            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"
            mIntent.putExtra(Intent.EXTRA_EMAIL, addressees)
            mIntent.putExtra(Intent.EXTRA_SUBJECT, "ಶ್ರೀ ವೀರಭದ್ರಸ್ವಾಮಿ ಸ್ತೋತ್ರಮಾಲಾ ಪ್ರತಿಕ್ರಿಯೆ")
            mIntent.putExtra(Intent.EXTRA_TEXT, "ನಮಸ್ಕಾರ")
            try {
                startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val mIntent = Intent(applicationContext, MainActivity::class.java)
        mIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        mIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(mIntent)
        finish()
    }
}