package com.arka.veerabhadreshwaramantra

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ViewPagerDashboard : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var btnPrevious: Button
    private lateinit var btnNext: Button
    private var imagesList = listOf<Int>()
    private var textLongList = listOf<String>()
    private lateinit var heading: String
    private lateinit var lyButtonsBg: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpager_dashboard)
        val pos = intent.getIntExtra("Position", 0)
//        Toast.makeText(applicationContext, "Rel" + pos, Toast.LENGTH_LONG).show()
        if (pos == 0) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸುಪ್ರಭಾತ"
            imagesList = listOf(
                R.string.suprabathanam
            )
        } else if (pos == 1) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಕವಚಂ"
            imagesList = listOf(
                R.string.kavacham
            )
        } else if (pos == 2) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ದಂಡಕಂ"
            imagesList = listOf(
                R.string.dhandakam,
                R.string.dhandakam1
            )
        } else if (pos == 3) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ತಾರಾವಳಿ"
            imagesList = listOf(
                R.string.tharavali
            )
        } else if (pos == 4) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರಾಷ್ಟಕಂ"
            imagesList = listOf(
                R.string.veerabhadrastaka
            )
        } else if (pos == 5) {
            heading = "ಶ್ರೀ ಭದ್ರ ಕವಚಂ"
            imagesList = listOf(
                R.string.kavacham
            )
        } else if (pos == 6) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಹಸ್ರನಾಮಸ್ತೋತ"
            imagesList = listOf(
                R.string.shatanamavali
            )
        } else if (pos == 7) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಹಸ್ರನಾಮವಳಿ"
            imagesList = listOf(
                R.string.sahasrastotram
            )
        } else if (pos == 8) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ ಸ್ತೋತ್ರO"
            imagesList = listOf(
                R.string.shatanamavali
            )
        } else if (pos == 9) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ"
            imagesList = listOf(
                R.string.shatanamavali
            )
        } else if (pos == 10) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ವಡಪುಗಳು"
            imagesList = listOf(
                R.string.vadapu1,
                R.string.vadapu2,
                R.string.vadapu3,
                R.string.vadapu4,
                R.string.vadapu5,
                R.string.vadapu6,
                R.string.vadapu7,
                R.string.vadapu8,
                R.string.vadapu9,
                R.string.vadapu10,
                R.string.vadapu11,
                R.string.vadapu12,
                R.string.vadapu13,
                R.string.vadapu14,
                R.string.vadapu15,
                R.string.vadapu16,
                R.string.vadapu17,
                R.string.vadapu18,
                R.string.vadapu19,
                R.string.vadapu20,
                R.string.vadapu21,
                R.string.vadapu22,
                R.string.vadapu23,
                R.string.vadapu24,
                R.string.vadapu25,
                R.string.vadapu26
            )
        } else if (pos == 11) {
            heading = "ಗುಗ್ಗುಳದ ಬಗ್ಗೆ ಮಾಹಿತಿ"
            imagesList = listOf(
                R.string.guggala
            )
        } else if (pos == 12) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಮಂಗಳಾರತಿ ಪದಗಳು"
            imagesList = listOf(
                R.string.mangalarathi1,
                R.string.managalarathi2,
                R.string.managalarathi3,
                R.string.mangalarathi4,
                R.string.mangalarathi5,
                R.string.mangalarathi6,
                R.string.mangalarathi7,
                R.string.mangalarathi8,
                R.string.mangalarathi9,
                R.string.mangalarathi10,
                R.string.mangalarathi11
            )
        } else if (pos == 13) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಶತಕ"
            imagesList = listOf(
                R.string.shatanamavali
            )
        } else if (pos == 14) {
            heading = "ದ್ವಾತ್ರಿಂಶದ್ಭುಜ ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನಂ"
            imagesList = listOf(
                R.string.dhyanam

            )
        } else if (pos == 15) {
            heading = "ಶ್ರೀ ಶರಭ ಹೃದಯ ಸ್ತೋತ್ರ"
            imagesList = listOf(
            )
        } else if (pos == 16) {
            heading = "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಅಷ್ಟಕ"
            imagesList = listOf(
                R.string.badrakaliastaka
            )
        } else if (pos == 17) {
            heading = "ಶ್ರೀ ಶರಭೋಪನಿಷತ್ತು"
            imagesList = listOf(
                R.string.sharabhoshanith
            )
        } else {
            heading = "ಪುಷ್ಪಾಂಜಲಿ"
            imagesList = listOf(
                R.string.pushpajali
            )
        }

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = heading
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        btnPrevious = findViewById(R.id.btnPrevious)
        btnNext = findViewById(R.id.btnNext)
        lyButtonsBg = findViewById(R.id.lyButtonsBg)

        if (imagesList.size > 1) {
            btnPrevious.visibility = View.VISIBLE
            btnNext.visibility = View.VISIBLE
            lyButtonsBg.visibility = View.VISIBLE
        } else {
            lyButtonsBg.visibility = View.GONE
            btnPrevious.visibility = View.GONE
            btnNext.visibility = View.GONE
        }
        val adapter = ViewPagerAdapter(imagesList)
        viewPager2 = findViewById(R.id.viewPager)
//        viewPager2.setCurrentItem(0)
        viewPager2.adapter = adapter

        btnPrevious.setOnClickListener {
            val currPos: Int = viewPager2.currentItem
//            if (currPos != 0) {
            viewPager2.currentItem = currPos - 1

//            }
        }

        btnNext.setOnClickListener {
            val currPos: Int = viewPager2.currentItem
//            if (currPos != 0) {
            viewPager2.currentItem = currPos + 1
//                viewPager2.setCurrentItem(viewPager2.currentItem)
//            }
        }

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