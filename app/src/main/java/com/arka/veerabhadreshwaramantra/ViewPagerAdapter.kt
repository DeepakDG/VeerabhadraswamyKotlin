package com.arka.veerabhadreshwaramantra

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    private val imagesList: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val image = imagesList[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }


    class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivSliderImage = itemView.findViewById<TextView>(R.id.ivSliderImage)

        fun bind(image: Int) {
            ivSliderImage.setText(image)
        }
    }
}