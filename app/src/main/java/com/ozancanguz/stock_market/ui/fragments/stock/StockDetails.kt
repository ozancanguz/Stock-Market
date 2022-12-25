package com.ozancanguz.stock_market.ui.fragments.stock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentStockDetailsBinding


class StockDetails : Fragment() {
    private var _binding: FragmentStockDetailsBinding? = null

    private val binding get() = _binding!!
    private val args:StockDetailsArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStockDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        // update ui
        updateUi()


        return view
    }

    private fun updateUi() {
        val args=args.currentStock
        binding.detailsStockText.text=args.text
        binding.detailsStockHacim.text="Volume: " +args.hacimstr+ " TRY"
        binding.detailsStockMaxx.text="Max Price: "+args.maxstr +" TRY"
        binding.detailsStockMin.text="Min Price: " +args.minstr +" TRY"
        binding.detailsStockRate.text="Rate: % "+args.rate.toString()
        binding.detailsStockTime.text="Time: " +args.time
    }


}