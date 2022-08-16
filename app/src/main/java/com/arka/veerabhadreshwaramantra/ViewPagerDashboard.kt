package com.arka.veerabhadreshwaramantra

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class ViewPagerDashboard : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var btnPrevious: Button
    private lateinit var btnNext: Button
    private var imagesList = listOf<Int>()
    private lateinit var heading: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpager_dashboard)
        val pos = intent.getIntExtra("Position", 0)
//        Toast.makeText(applicationContext, "Rel" + pos, Toast.LENGTH_LONG).show()
        if (pos == 0) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸುಪ್ರಭಾತ"
            imagesList = listOf(
                R.string.subrathanam
            )
        } else if (pos == 1) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಕವಚಂ"
            imagesList = listOf(
                R.string.kavacha2
            )
        } else if (pos == 2) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ದಂಡಕಂ"
            imagesList = listOf(
                R.string.dhandankam
            )
        } else if (pos == 3) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ತಾರಾವಳಿ"
            imagesList = listOf(
                R.string.tharalavali
            )
        } else if (pos == 4) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರಾಷ್ಟಕಂ"
            imagesList = listOf(
                R.string.veerabhadrastaka
            )
        } else if (pos == 5) {
            heading = "ಶ್ರೀ ಭದ್ರ ಕವಚಂ"
            imagesList = listOf(
                R.string.kavacha
            )
        } else if (pos == 6) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಹಸ್ರನಾಮಸ್ತೋತ"
            imagesList = listOf(
                R.string.sahasranamavali
            )
        } else if (pos == 7) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಹಸ್ರನಾಮವಳಿ"
            imagesList = listOf(
                R.string.vadapu3
            )
        } else if (pos == 8) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ ಸ್ತೋತ್ರO"
            imagesList = listOf(
                R.string.astothara_shathanamavali
            )
        } else if (pos == 9) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ"
            imagesList = listOf(
                R.string.shathanamavali
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
                R.string.vadapu22
            )
        } else if (pos == 11) {
            heading = "ಗುಗ್ಗುಳದ ಬಗ್ಗೆ ಮಾಹಿತಿ"
            imagesList = listOf(
                R.string.guggala
            )
        } else if (pos == 12) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಂಕ್ಷಿಪ್ತ ಪರಿಚಯ"
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 13) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಆಚರಣೆಗಳು"
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 14) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಪ್ರಾರ್ಥನ"
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 15) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಮಂಗಳ ಶ್ಲೋಕ"
            imagesList = listOf(
                R.string.mangalarathi,
                R.string.mangalarathi2,
                R.string.mangalarathi3,
                R.string.mangalarathi4,
                R.string.managalarathi5,
                R.string.mangalarathi6,
                R.string.mangalarathi7
            )
        } else if (pos == 16) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಶತಕ"
            imagesList = listOf(
                R.string.shathaka
            )
        } else if (pos == 17) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಮಂಗಳ"
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 18) {
            heading = "ದ್ವಾತ್ರಿಂಶದ್ಭುಜ ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನಂ"
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 19) {
            heading = "ಶ್ರೀ ಶರಭ ಹೃದಯ ಸ್ತೋತ್ರ"
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 20){
            heading = "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಅಷ್ಟಕ"
            imagesList = listOf(
                R.string.badrakaliastaka
            )
        } else {
            heading = "ಶ್ರೀ ಶರಭೋಪನಿಷತ್ತು"
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
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

        if(imagesList.size > 1){
            btnPrevious.visibility = View.VISIBLE
            btnNext.visibility = View.VISIBLE
        }else{
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}