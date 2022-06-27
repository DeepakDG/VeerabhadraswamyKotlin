package com.arka.veerabhadreshwaramantra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.arka.veerabhadreshwaramantra.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_second, container, false)
        activity?.title = "書籍情報"

        // 一覧画面から渡されたデータをviewに表示する
        setFragmentResultListener("bookData") { _, bundle ->
//            tv_book_name.text = bundle.getString("bookName")
//            tv_book_price.text = bundle.getInt("bookPrice").toString()
//            tv_book_purchase_date.text = bundle.getString("bookPurchaseDate")
        }

        return view
    }
}