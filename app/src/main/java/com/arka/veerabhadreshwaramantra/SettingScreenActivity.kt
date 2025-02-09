package com.arka.veerabhadreshwaramantra

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class SettingScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settingscreenactivtity)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "ಸೆಟ್ಟಿಂಗ್ ಸ್ಕ್ರೀನ್"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        fragmentManager.beginTransaction().add(R.id.idFrameLayout, SettingsScreen()).commit()
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
            super.onBackPressed()
            val mIntent = Intent(applicationContext, MainActivity::class.java)
            mIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            mIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(mIntent)
            finish()
        }
    }