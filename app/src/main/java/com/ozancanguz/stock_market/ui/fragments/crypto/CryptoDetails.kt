package com.ozancanguz.stock_market.ui.fragments.crypto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentCryptoDetailsBinding


class CryptoDetails : Fragment() {
    private var _binding: FragmentCryptoDetailsBinding? = null

    private val binding get() = _binding!!
    private val args:CryptoDetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCryptoDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        updateUi()

        return view
    }

    private fun updateUi() {
        binding.detailsCryptoCode.text="Code: "+args.currentCrypto.code
        binding.detailsCryptoChangeDay.text="Change Daily: % "+args.currentCrypto.changeDaystr
        binding.detailsCryptoChangeWeek.text="Change Weekly % " +args.currentCrypto.changeWeekstr
        binding.detailsCryptoName.text="Name: " +args.currentCrypto.name
        binding.changeHours.text="Change Hoursly: % " +args.currentCrypto.changeHourstr
    }


}