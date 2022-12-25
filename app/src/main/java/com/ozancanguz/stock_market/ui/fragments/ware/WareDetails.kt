package com.ozancanguz.stock_market.ui.fragments.ware

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentWareDetailsBinding


class WareDetails : Fragment() {
    private var _binding: FragmentWareDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:WareDetailsArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWareDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        updateLiveData()


        return view

    }

    private fun updateLiveData() {
        val args=args.currentWare
        binding.detailsWareName.text="Name: " +args.name
        binding.detailsWareText.text=args.text
        binding.detailsWareBuying.text="Buying: "+args.buyingstr +" USD"
        binding.detailsWareSelling.text="Selling: " +args.sellingstr+ " USD"
        binding.detailsWareRate.text="Rate: %" +args.rate
        binding.detailsWareUpdateTime.text="Update Time: " +args.datetime

    }


}