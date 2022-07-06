package com.arka.veerabhadreshwaramantra

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class ViewPagerDashboard : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var btnPrevious : Button
    private lateinit var btnNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpager_dashboard)

        val imagesList = listOf(
            R.drawable.ic_launcher_background,
            R.drawable.virabhadra,
            R.drawable.virabhadra
        )
        btnPrevious = findViewById(R.id.btnPrevious)
        btnNext = findViewById(R.id.btnNext)
        val adapter = ViewPagerAdapter(imagesList)
        viewPager2 = findViewById(R.id.viewPager)
        viewPager2.adapter = adapter

        btnPrevious.setOnClickListener{
            val currPos: Int = viewPager2.currentItem
            if (currPos != 0) {
                viewPager2.currentItem = currPos - 1
            }
        }

        btnNext.setOnClickListener{
            val currPos: Int = viewPager2.currentItem
            if (currPos != 0) {
                viewPager2.currentItem = currPos + 1
            }
        }
    }
}