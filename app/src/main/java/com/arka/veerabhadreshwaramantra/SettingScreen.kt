package com.arka.veerabhadreshwaramantra

import android.graphics.Color
import android.os.Bundle
import android.preference.ListPreference
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SettingsScreen : PreferenceFragment() {
    private lateinit var colorPickerDialog: AlertDialog
    private lateinit var content: ConstraintLayout
    private var tinyDB: TinyDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preference)

        tinyDB = TinyDB(activity)

        val prefTextBold =
            findPreference(getString(R.string.app_text_bold))

        val vibrateSwitch =
            findPreference(getString(R.string.prefs_color_theme))
        bindPreferenceSummaryToValue(findPreference(getString(R.string.key_list_preference)))

        if (prefTextBold != null) {
            prefTextBold.setOnPreferenceChangeListener { arg0, isVibrateOnObject ->
                val isTextBold = isVibrateOnObject as Boolean
                if (isTextBold) {
                    tinyDB!!.putBoolean("SelectedTextBold", isTextBold)
                    Log.d("SelectedTextBold ", isTextBold.toString());
                }
                true
            }
        }

        if (vibrateSwitch != null) {
            vibrateSwitch.setOnPreferenceChangeListener { arg0, isVibrateOnObject ->
                val isVibrateOn = isVibrateOnObject as Boolean
                if (isVibrateOn) {
                    showColorPickerDialog()
                }
                true
            }
        }
    }

    private val sBindPreferenceSummaryToValueListener =
        Preference.OnPreferenceChangeListener { preference, value ->
            val stringValue = value.toString()
            tinyDB!!.putString("selectedTextSize", stringValue)
            if (preference is ListPreference) {
                val listPreference = preference
                val index = listPreference.findIndexOfValue(stringValue)
                preference.setSummary(
                    if (index >= 0)
                        listPreference.entries[index]
                    else
                        null
                )
            }
            true
        }

    private fun bindPreferenceSummaryToValue(preference: Preference) {
        preference.onPreferenceChangeListener = sBindPreferenceSummaryToValueListener
        sBindPreferenceSummaryToValueListener.onPreferenceChange(
            preference,
            PreferenceManager
                .getDefaultSharedPreferences(preference.context)
                .getString(preference.key, "")
        )
    }

    private fun showColorPickerDialog() {
        val colors = listOf(
            Color.CYAN,
            Color.rgb(179, 157, 219),
            Color.MAGENTA,
            Color.rgb(245, 245, 220),
            Color.YELLOW,
            Color.rgb(169, 169, 169),
            Color.GREEN,
            Color.rgb(244, 164, 96),
            Color.BLUE,
            Color.RED,
            Color.rgb(255, 228, 181),
            Color.rgb(72, 61, 139),
            Color.rgb(205, 92, 92),
            Color.rgb(255, 165, 0),
            Color.rgb(102, 205, 170)
        )

        val numColumns = 5 // Desired number of columns
        val padding = dpToPx(15) // Convert 15 dp to pixels
        val spacing = dpToPx(15) // Set the spacing between items in dp

        val recyclerView = RecyclerView(activity).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            layoutManager = GridLayoutManager(activity, numColumns)
            setPadding(padding, dpToPx(20), padding, padding) // Convert padding to pixels
            adapter = ColorAdapter(activity, colors) { selectedColor ->

                tinyDB!!.putInt("SelectedColor", selectedColor)
                Log.d("selectedColor ", selectedColor.toString());
                colorPickerDialog.dismiss()
            }
            addItemDecoration(GridSpacingItemDecoration(numColumns, spacing, true))
        }

        colorPickerDialog = AlertDialog.Builder(activity, R.style.CustomAlertDialogTheme)
            .setTitle("Choose a color")
            .setView(recyclerView)
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        colorPickerDialog.show()
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }
}