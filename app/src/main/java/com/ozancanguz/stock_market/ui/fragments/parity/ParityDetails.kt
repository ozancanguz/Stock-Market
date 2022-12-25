package com.ozancanguz.stock_market.ui.fragments.parity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentParityDetailsBinding


class ParityDetails : Fragment() {
    private var _binding: FragmentParityDetailsBinding? = null

    private val binding get() = _binding!!
    private val args:ParityDetailsArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParityDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        updateUi()


        return view

    }

    private fun updateUi() {
        val currentParity=args.currentParity
        binding.detailParityName.text="Name: "+currentParity.name
        binding.detailsParityText.text=currentParity.text
        binding.detailsParityBuying.text="Buying: " +currentParity.buyingstr
        binding.detailsParitySelling.text="Selling : " +currentParity.sellingstr
        binding.detailsParityDateTime.text="UpdateTime: " +currentParity.datetime
        binding.detailsParityRate.text="Rate: " +currentParity.rate
    }


}