package com.arka.veerabhadreshwaramantra

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ViewPagerDashboard : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private var imagesList = listOf<String>()
    private var textLongList = listOf<String>()
    private lateinit var heading: String
    private var tinyDB: TinyDB? = null
    private lateinit var activity_main:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contentdetails)
        tinyDB = TinyDB(applicationContext)
        val themeColor = tinyDB!!.getInt("SelectedColor");
        Log.d("themeColor ", themeColor.toString());
        activity_main = findViewById<ConstraintLayout>(R.id.dashboard_details_content)
        activity_main.setBackgroundColor(themeColor)
        val pos = intent.getIntExtra("Position", 0)
//        Toast.makeText(applicationContext, "Rel" + pos, Toast.LENGTH_LONG).show()
        if (pos == 0) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸುಪ್ರಭಾತ"
            imagesList = listOf(
                getString(R.string.suprabathanam)
            )
        } else if (pos == 1) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಕವಚಂ"
            imagesList = listOf(
                getString(R.string.kavacham)
            )
        } else if (pos == 2) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ದಂಡಕಂ ಸ್ತೋತ್ರಂ"
            imagesList = listOf(
                getString(R.string.dhandakam_original)
            )
        } else if (pos == 3) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ದಂಡಕಂ"
            imagesList = listOf(
                getString(R.string.dhandakam_new)
            )
        } else if (pos == 4) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ತಾರಾವಳಿ"
            imagesList = listOf(
                getString(R.string.tharavali)
            )
        } else if (pos == 5) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರಾಷ್ಟಕಂ"
            imagesList = listOf(
                getString(R.string.veerabhadrastaka)
            )
        } else if (pos == 6) {
            heading = "ಶ್ರೀ ಭದ್ರ ಕವಚಂ"
            imagesList = listOf(
                getString(R.string.bhadra_kavacha_new)
            )
        } else if (pos == 7) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಹಸ್ರನಾಮಸ್ತೋತ"
            imagesList = listOf(
                getString(R.string.sahasrastotram1) +
                        getString(R.string.sahasrastotram2) +
                        getString(R.string.sahasrastotram3)
            )
        } else if (pos == 8) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಹಸ್ರನಾಮವಳಿ"
            imagesList = listOf(
                getString(R.string.atha_sahasranamaval1) +
                        getString(R.string.atha_sahasranamaval2) +
                        getString(R.string.atha_sahasranamaval3) +
                        getString(R.string.atha_sahasranamaval4) +
                        getString(R.string.atha_sahasranamaval5)
            )
        } else if (pos == 9) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ ಸ್ತೋತ್ರO"
            imagesList = listOf(
                getString(R.string.shatanamavali)
            )
        } else if (pos == 10) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ವಡಪುಗಳು"
            imagesList = listOf(
                getString(R.string.vadapu1),
                getString(R.string.vadapu2),
                getString(R.string.vadapu3),
                getString(R.string.vadapu4),
                getString(R.string.vadapu5),
                getString(R.string.vadapu6),
                getString(R.string.vadapu7),
                getString(R.string.vadapu8),
                getString(R.string.vadapu9),
                getString(R.string.vadapu10),
                getString(R.string.vadapu11),
                getString(R.string.vadapu12),
                getString(R.string.vadapu13),
                getString(R.string.vadapu14),
                getString(R.string.vadapu15),
                getString(R.string.vadapu16),
                getString(R.string.vadapu17),
                getString(R.string.vadapu18),
                getString(R.string.vadapu19),
                getString(R.string.vadapu20),
                getString(R.string.vadapu21),
                getString(R.string.vadapu22),
                getString(R.string.vadapu23),
                getString(R.string.vadapu24),
                getString(R.string.vadapu25),
                getString(R.string.vadapu26)
            )
        } else if (pos == 11) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರಾಷ್ಟೋತ್ತರ ಸ್ತೋತ್ರಂ"
            imagesList = listOf(
                getString(R.string.veerabhadrastotram1),
                getString(R.string.veerabhadrastotram2)
            )
        } else if (pos == 12) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಮಂಗಳಾರತಿ ಪದಗಳು"
            imagesList = listOf(
                getString(R.string.mangalarathi1),
                getString(R.string.managalarathi2),
                getString(R.string.managalarathi3),
                getString(R.string.mangalarathi4),
                getString(R.string.mangalarathi5),
                getString(R.string.mangalarathi6),
                getString(R.string.mangalarathi7),
                getString(R.string.mangalarathi8),
                getString(R.string.mangalarathi9),
                getString(R.string.mangalarathi10),
                getString(R.string.mangalarathi11)
            )
        } else if (pos == 13) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಶತಕ"
            imagesList = listOf(
                getString(R.string.shathaka1) +
                        getString(R.string.shathaka2) +
                        getString(R.string.shathaka3) +
                        getString(R.string.shathaka4)
            )
        } else if (pos == 14) {
            heading = "ದ್ವಾತ್ರಿಂಶದ್ಭುಜ ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನಂ"
            imagesList = listOf(
                getString(R.string.dhyanam)
            )
        } else if (pos == 15) {
            heading = "ಶ್ರೀವೀರಭದ್ರಸ್ವಾಮಿ ಸ್ತೋತ್ರಂ"
            imagesList = listOf(
                 getString(R.string.veerabhadrastotram_new)
            )
        } else if (pos == 16) {
            heading = "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಅಷ್ಟಕ"
            imagesList = listOf(
                getString(R.string.badrakaliastaka)
            )
        } else if (pos == 17) {
            heading = "ಶ್ರೀ ಶರಭೋಪನಿಷತ್ತು"
            imagesList = listOf(
                getString(R.string.sharabhoshanith)
            )
        } else if (pos == 18) {
            heading = "ಗುಗ್ಗುಳದ ಬಗ್ಗೆ ಮಾಹಿತಿ"
            imagesList = listOf(
                getString(R.string.guggala)
            )
        } else if (pos == 19) {
            heading = "ವೀರಭದ್ರ ಮಹಾಮಂತ"
            imagesList = listOf(
                getString(R.string.mahamantra2)
            )
        } else if (pos == 20) {
            heading = "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಸ್ತುತಿ"
            imagesList = listOf(
                getString(R.string.badrakalistuti)
            )
        } else {
            heading = "ಪುಷ್ಪಾಂಜಲಿ"
            imagesList = listOf(
                getString(R.string.pushpajali)
            )
        }

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = heading
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        val adapter = ViewPagerAdapter(imagesList)
        viewPager2 = findViewById(R.id.viewPagerdetails)
//        viewPager2.setCurrentItem(0)
        viewPager2.adapter = adapter

    }

    override fun onResume() {
        super.onResume()

    }

    private fun getTermsString(): String {
        val termsString = StringBuilder()
        val reader: BufferedReader
        try {
            reader = BufferedReader(
                InputStreamReader(assets.open("atha_sahasranamavali.txt"))
            )
            var str: String?
            while (reader.readLine().also { str = it } != null) {
                termsString.append(str)
            }
            reader.close()
            return termsString.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ""
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}