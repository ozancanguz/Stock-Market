package com.ozancanguz.stock_market.ui.fragments.stock

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
import com.ozancanguz.stock_market.data.adapters.StockListAdapter
import com.ozancanguz.stock_market.databinding.FragmentStockBinding
import com.ozancanguz.stock_market.viewmodels.StockViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockFragment : Fragment() {
    private var _binding: FragmentStockBinding? = null

    private val binding get() = _binding!!

    private val stockViewModel:StockViewModel by viewModels()

    private val stockListAdapter=StockListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStockBinding.inflate(inflater, container, false)
        val view = binding.root


        // observe live data
        observeLiveData()

        // set up rv
        setupRv()



        return view
    }

    private fun setupRv() {
        binding.StockRv.layoutManager=LinearLayoutManager(requireContext())
        binding.StockRv.adapter=stockListAdapter

    }

    private fun observeLiveData() {
        stockViewModel.getStockPrices()
        stockViewModel.stockList.observe(viewLifecycleOwner, Observer {
            Log.d("stockfragment",""+it)
            stockListAdapter.setData(it)
        })
    }


}