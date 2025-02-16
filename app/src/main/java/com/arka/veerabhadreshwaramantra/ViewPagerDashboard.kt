package com.arka.veerabhadreshwaramantra

import android.os.Bundle
import android.util.Log
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
    private lateinit var activity_main: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contentdetails)
        tinyDB = TinyDB(applicationContext)

        val themeColor = tinyDB!!.getInt("SelectedColor");
        Log.d("themeColor ", themeColor.toString());
        activity_main = findViewById<ConstraintLayout>(R.id.dashboard_details_content)
        activity_main.setBackgroundColor(themeColor)

        val pos = intent.getIntExtra("Position", 0)
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
            heading = "ವೀರಾಗಮದಲ್ಲಿನ ಭದ್ರಕವಚ"
            imagesList = listOf(
                getString(R.string.bhadra_kavacha)
            )
        } else if (pos == 3) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ದಂಡಕಂ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_dhandakam)
            )
        } else if (pos == 4) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಪಂಚಕಂ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_panchakam)
            )
        } else if (pos == 5) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ರತ್ನ ಪಂಚಕಂ ಸ್ತುತಿ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_ratna_panchakam_sthuthi)
            )
        } else if (pos == 6) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರಾಷ್ಟಕಂ"
            imagesList = listOf(
                getString(R.string.veerabhadrastaka)
            )
        } else if (pos == 7) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಶತಕ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_shathaka1) +
                        getString(R.string.Sri_veerabhadra_shathaka2) + getString(R.string.Sri_veerabhadra_shathaka3) + getString(
                    R.string.Sri_veerabhadra_shathaka4
                ) + getString(R.string.Sri_veerabhadra_shathaka5) + getString(R.string.Sri_veerabhadra_shathaka6)
            )
        } else if (pos == 8) {
            heading = "ಶ್ರೀವೀರಭದ್ರ ಶರಣಾಗತಿ ಸ್ತೋತ್ರಂ"
            imagesList = listOf(
                getString(R.string.veerabhadra_sharanaagati_sthotram)
            )
        } else if (pos == 9) {
            heading = "ಶ್ರೀವೀರಭದ್ರ ಭುಜಂಗ ಸ್ತೋತ್ರ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_bhujanga_sthotra)
            )
        } else if (pos == 10) {
            heading = "ಆತ್ಮಾವೀರೇಶ್ವರಸ್ತೋತ್ರಂ"
            imagesList = listOf(
                getString(R.string.athma_veereswars_stotram)
            )
        } else if (pos == 11) {
            heading = "ಶ್ರೀವೀರಭದ್ರಸ್ವಾಮಿ ಸ್ತೋತ್ರ"
            imagesList = listOf(
                getString(R.string.Sri_Veerabhadra_sthotra)
            )
        } else if (pos == 12) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಅಷ್ಟೋತ್ತರ\n" +
                    "ಶತನಾಮಾವಳಿ ಸ್ತೋತ್ರ"
            imagesList = listOf(
                getString(R.string.Sri_Veerabhadra_ashtottara_shata_namavali_sthotra)
            )
        } else if (pos == 13) {
            heading = "ಶ್ರೀವೀರಭದ್ರ ಸಹಸ್ರನಾಮ ಸ್ತೋತ್ರಮ್"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_sahasranama_sthotra1) +
                        getString(R.string.Sri_veerabhadra_sahasranama_sthotra2) +
                        getString(R.string.Sri_veerabhadra_sahasranama_sthotra3) +
                        getString(R.string.Sri_veerabhadra_sahasranama_sthotra4) +
                        getString(R.string.Sri_veerabhadra_sahasranama_sthotra5) +
                        getString(R.string.Sri_veerabhadra_sahasranama_sthotra6) +
                        getString(R.string.Sri_veerabhadra_sahasranama_sthotra7) +
                        getString(R.string.Sri_veerabhadra_sahasranama_sthotra8)
            )
        } else if (pos == 14) {
            heading = "ಶ್ರೀವೀರಭದ್ರ ನಕ್ಷತ್ರ ನಾಮಾವಲಿಃ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_nakshatra_namavali)
            )
        } else if (pos == 15) {
            heading = "ವೀರಭದ್ರಾಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadraastottara_shata_namavali)
            )
        } else if (pos == 16) {
            heading = "ಶ್ರೀವೀರಭದ್ರ ಸಹಸ್ರ ನಾಮಾವಲಿಃ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_sahasranamavali1) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali2) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali3) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali4) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali5) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali6) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali7) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali8) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali9) +
                        getString(R.string.Sri_veerabhadra_sahasranamavali10)
            )
        } else if (pos == 17) {
            heading = "ಶ್ರೀವೀರಭದ್ರ ಮಾಲಾ ಮಹಾಮಂತ್ರಃ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_malamaha_manthra)
            )
        } else if (pos == 18) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಮೂಲಮಂತ್ರ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_moola_mantra)
            )
        } else if (pos == 19) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಅಘೋರ ಮಂತ್ರ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_aghora_mantra)
            )
        } else if (pos == 20) {
            heading = "ಶರಭೋಪನಿಷತ್"
            imagesList = listOf(
                getString(R.string.sharabhopanisatthu)
            )
        } else if (pos == 21) {
            heading = "ಶ್ರೀಶರಭ ಹೃದಯ ಸ್ತೋತ್ರಂ"
            imagesList = listOf(
                getString(R.string.Sri_sharabha_hrudaya_sthotra)
            )
        } else if (pos == 22) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನ ಶ್ಲೋಕಗಳು"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_dyanasloka1),
                getString(R.string.Sri_veerabhadra_dyanasloka2),
                getString(R.string.Sri_veerabhadra_dyanasloka3),
                getString(R.string.Sri_veerabhadra_dyanasloka4)
            )
        } else if (pos == 23) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನಂ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_dyanam)
            )
        } else if (pos == 24) {
            heading = "ಶ್ರೀ ಅಘೋರ ವೀರಭದ್ರ ಧ್ಯಾನಂ"
            imagesList = listOf(
                getString(R.string.Sri_aghora_veerabhadra_dyanam)
            )
        } else if (pos == 25) {
            heading = "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಭವಾನಿ ಧ್ಯಾನ"
            imagesList = listOf(
                getString(R.string.Sri_bhadrakali_bhavani_dyana)
            )
        } else if (pos == 26) {
            heading = "ಶ್ರೀಭದ್ರಕಾಳೀ ಕವಚಂ"
            imagesList = listOf(
                getString(R.string.Sri_bhadrakali_kavachanm)
            )
        } else if (pos == 27) {
            heading = "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಅಷ್ಟಕಂ"
            imagesList = listOf(
                getString(R.string.Sri_bhdrakali_astakam)
            )
        } else if (pos == 28) {
            heading = "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ"
            imagesList = listOf(
                getString(R.string.Sri_bhadrakali_astotthara_sathanamavali)
            )
        } else if (pos == 29) {
            heading = "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಸ್ತುತಿ"
            imagesList = listOf(
                getString(R.string.Sri_bhadrakali_stuthi)
            )
        } else if (pos == 30) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಗುಗ್ಗುಳದ ಬಗ್ಗೆ ಮಾಹಿತಿ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_guggala_information)
            )
        } else if (pos == 31) {
            heading = "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ವಡಪುಗಳು"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_vadapugalu1),
                getString(R.string.Sri_veerabhadra_vadapugalu2),
                getString(R.string.Sri_veerabhadra_vadapugalu3),
                getString(R.string.Sri_veerabhadra_vadapugalu4),
                getString(R.string.Sri_veerabhadra_vadapugalu5),
                getString(R.string.Sri_veerabhadra_vadapugalu6),
                getString(R.string.Sri_veerabhadra_vadapugalu7),
                getString(R.string.Sri_veerabhadra_vadapugalu8),
                getString(R.string.Sri_veerabhadra_vadapugalu9),
                getString(R.string.Sri_veerabhadra_vadapugalu10),
                getString(R.string.Sri_veerabhadra_vadapugalu11),
                getString(R.string.Sri_veerabhadra_vadapugalu12),
                getString(R.string.Sri_veerabhadra_vadapugalu13),
                getString(R.string.Sri_veerabhadra_vadapugalu14),
                getString(R.string.Sri_veerabhadra_vadapugalu15),
                getString(R.string.Sri_veerabhadra_vadapugalu16),
                getString(R.string.Sri_veerabhadra_vadapugalu17),
                getString(R.string.Sri_veerabhadra_vadapugalu18),
                getString(R.string.Sri_veerabhadra_vadapugalu19),
                getString(R.string.Sri_veerabhadra_vadapugalu20),
                getString(R.string.Sri_veerabhadra_vadapugalu21),
                getString(R.string.Sri_veerabhadra_vadapugalu22),
                getString(R.string.Sri_veerabhadra_vadapugalu23),
                getString(R.string.Sri_veerabhadra_vadapugalu24),
                getString(R.string.Sri_veerabhadra_vadapugalu25),
                getString(R.string.Sri_veerabhadra_vadapugalu26),
                getString(R.string.Sri_veerabhadra_vadapugalu27),
                getString(R.string.Sri_veerabhadra_vadapugalu28),
                getString(R.string.Sri_veerabhadra_vadapugalu29),
                getString(R.string.Sri_veerabhadra_vadapugalu30),
                getString(R.string.Sri_veerabhadra_vadapugalu31),
                getString(R.string.Sri_veerabhadra_vadapugalu32),
                getString(R.string.Sri_veerabhadra_vadapugalu33)
            )
        } else if (pos == 32) {
            heading = "ಜಯ ವೀರಭದ್ರ ಕರುಣಾ ಸಮುದ್ರಾ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_mangalaruthi1),
                getString(R.string.Sri_veerabhadra_mangalaruthi2),
                getString(R.string.Sri_veerabhadra_mangalaruthi3),
                getString(R.string.Sri_veerabhadra_mangalaruthi4),
                getString(R.string.Sri_veerabhadra_mangalaruthi5),
                getString(R.string.Sri_veerabhadra_mangalaruthi6),
                getString(R.string.Sri_veerabhadra_mangalaruthi7),
                getString(R.string.Sri_veerabhadra_mangalaruthi8),
                getString(R.string.Sri_veerabhadra_mangalaruthi9),
                getString(R.string.Sri_veerabhadra_mangalaruthi10),
                getString(R.string.Sri_veerabhadra_mangalaruthi11)
            )
        } else {
            heading = "ಶ್ರೀ ವೀರಭದ್ರ ಪುಷ್ವಾಂಜಲಿ"
            imagesList = listOf(
                getString(R.string.Sri_veerabhadra_puswanjali)
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