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
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 1) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 2) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 3) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 4) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 5) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 6) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 7) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 8) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 9) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 10) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 11) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
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
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 16) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
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
        } else if (pos == 20) {
             imagesList = listOf(
                R.string.vadapu3,
                R.string.vadapu3,
                R.string.vadapu3
            )
        } else if (pos == 21) {
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