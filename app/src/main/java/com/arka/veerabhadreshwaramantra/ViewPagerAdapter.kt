package com.arka.veerabhadreshwaramantra

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.common.io.Resources

class ViewPagerAdapter(
    private val imagesList: List<String>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    var tinyDB: TinyDB? = null
    var selectedTextSize: String = "5"
    var selectedTextFontFace: Boolean = false
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        tinyDB = TinyDB(parent.context)
        context = parent.context
        selectedTextSize = tinyDB!!.getString("selectedTextSize")
        selectedTextFontFace = tinyDB!!.getBoolean("SelectedTextBold")
        Log.d("SelectedTextBold ", selectedTextFontFace.toString());
        Log.d("selectedTextSize ", selectedTextSize.toString());
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val image = imagesList[position]
        holder.bind(image, selectedTextSize, true, context)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivSliderImage = itemView.findViewById<TextView>(R.id.ivSliderImage)

        fun bind(image: String, textSize: String, isBold: Boolean, context: Context) {
            ivSliderImage.setText(image)
            if (textSize == "15") {
                ivSliderImage.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP, 15f
                )
            } else if (textSize == "18") {
                ivSliderImage.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    18f
                )
            } else if (textSize == "24") {
                ivSliderImage.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    24f
                )
            } else if (textSize == "28") {
                ivSliderImage.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    28f
                )
            } else if (textSize == "30") {
                ivSliderImage.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    30f
                )
            } else if (textSize == "32") {
                ivSliderImage.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    32f
                )
            } else {
                ivSliderImage.setTextSize(
                    TypedValue.COMPLEX_UNIT_SP,
                    35f
                )
            }
            if (isBold) {
                ivSliderImage.setTypeface(ivSliderImage.getTypeface(), Typeface.BOLD)
            }
        }
    }
}