package com.arka.veerabhadreshwaramantra

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class ViewPagerDashboard : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var btnPrevious: Button
    private lateinit var btnNext: Button
    private var imagesList = listOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpager_dashboard)
        val pos = intent.getIntExtra("Position", 0)
        Toast.makeText(applicationContext, "Rel" + pos, Toast.LENGTH_LONG).show()
        if (pos == 0) {
            imagesList = listOf(
                R.string.subrathanam
            )
        } else if (pos == 1) {
            imagesList = listOf(
                R.string.kavacha2
            )
        } else if (pos == 2) {
            imagesList = listOf(
                R.string.dhandankam
            )
        } else if (pos == 3) {
            imagesList = listOf(
                R.string.tharalavali
            )
        } else if (pos == 4) {
            imagesList = listOf(
                R.string.veerabhadrastaka
            )
        } else if (pos == 5) {
            imagesList = listOf(
                R.string.kavacha
            )
        } else if (pos == 6) {
            imagesList = listOf(
                R.string.sahasranamavali
            )
        } else if (pos == 7) {
            imagesList = listOf(
                R.string.vadapu3
            )
        } else if (pos == 8) {
            imagesList = listOf(
                R.string.astothara_shathanamavali
            )
        } else if (pos == 9) {
            imagesList = listOf(
                R.string.shathanamavali
            )
        } else if (pos == 10) {
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
            imagesList = listOf(
                R.string.guggala
            )
        } else if (pos == 12) {
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 13) {
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 14) {
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 15) {
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
            imagesList = listOf(
                R.string.shathaka
            )
        } else if (pos == 17) {
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 18) {
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 18) {
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 19) {
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else {
            imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        }

        btnPrevious = findViewById(R.id.btnPrevious)
        btnNext = findViewById(R.id.btnNext)
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
}