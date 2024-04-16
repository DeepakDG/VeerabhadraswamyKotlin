package com.arka.veerabhadreshwaramantra

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Vibrator
import android.preference.PreferenceFragment
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.preference.Preference
import androidx.preference.SwitchPreference
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SettingsScreen : PreferenceFragment() {

    private lateinit var colorPickerDialog: AlertDialog
    private lateinit var content: ConstraintLayout
    private var tinyDB: TinyDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // below line is used to add preference
        // fragment from our xml folder.
        addPreferencesFromResource(R.xml.preference)

        tinyDB = TinyDB(activity)
        val vibrateSwitch : android.preference.Preference  =
            findPreference(getString(R.string.prefs_restricted_mode))

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

    private fun showColorPickerDialog() {

        val colors = listOf(
            Color.CYAN, Color.rgb(179, 157, 219), Color.MAGENTA, Color.rgb(245, 245, 220), Color.YELLOW,
            Color.rgb(169, 169, 169), Color.GREEN, Color.rgb(244, 164, 96), Color.BLUE, Color.RED,
            Color.rgb(255, 228, 181), Color.rgb(72, 61, 139), Color.rgb(205, 92, 92), Color.rgb(255, 165, 0), Color.rgb(102, 205, 170)
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
