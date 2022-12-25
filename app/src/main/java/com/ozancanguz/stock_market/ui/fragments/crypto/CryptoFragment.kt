package com.ozancanguz.stock_market.ui.fragments.crypto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.data.adapters.CryptoAdapter
import com.ozancanguz.stock_market.databinding.FragmentCryptoBinding
import com.ozancanguz.stock_market.viewmodels.CryptoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoFragment : Fragment() {
    private var _binding: FragmentCryptoBinding? = null

    private val binding get() = _binding!!

    // init viewmodel
    private val cryptoViewModel:CryptoViewModel by viewModels()

    // init adapter
    private val cryptoAdapter=CryptoAdapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCryptoBinding.inflate(inflater, container, false)
        val view = binding.root

        // observe live data and update ui
        updateUi()

        // setup rv
        setupRv()

        return view
    }

    private fun setupRv() {
        binding.cryptoRv.layoutManager=LinearLayoutManager(requireContext())
        binding.cryptoRv.adapter=cryptoAdapter
    }

    private fun updateUi() {
        cryptoViewModel.requestCryptoData()
        cryptoViewModel.cryptoList.observe(viewLifecycleOwner, Observer {
            Log.d("cryptoFragment",""+it)
            cryptoAdapter.setData(it)
        })
    }


}