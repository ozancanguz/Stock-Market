package com.ozancanguz.stock_market.ui.fragments.gold

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentGoldDetailsBinding


class GoldDetails : Fragment() {

    private var _binding: FragmentGoldDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:GoldDetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGoldDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

      updateUi()

        return view
    }

    private fun updateUi() {
        binding.detailsImage.setImageResource(R.drawable.backi)
        binding.detailsButing.text="Buying: " +args.currentgold.buyingstr +" TRY"
        binding.detailsSelling.text="Selling : "+args.currentgold.sellingstr + " TRY"
        binding.detailsDateTime.text="Date Time: " +args.currentgold.datetime
    }


}