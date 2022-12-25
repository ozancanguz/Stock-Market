package com.ozancanguz.stock_market.ui.fragments.parity

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
import com.ozancanguz.stock_market.data.adapters.ParityListAdapter
import com.ozancanguz.stock_market.databinding.FragmentParityBinding
import com.ozancanguz.stock_market.viewmodels.ParityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParityFragment : Fragment() {
    private var _binding: FragmentParityBinding? = null

    private val binding get() = _binding!!

    private val parityViewModel:ParityViewModel by viewModels()

    private val parityListAdapter=ParityListAdapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParityBinding.inflate(inflater, container, false)
        val view = binding.root


        // observe live data and update ui
        observeLiveData()

        // setup rv
        setupRv()

        return view
    }

    private fun setupRv() {
        binding.parityRv.layoutManager=LinearLayoutManager(requireContext())
        binding.parityRv.adapter=parityListAdapter
    }

    private fun observeLiveData() {
        parityViewModel.requestParityData()
        parityViewModel.parityList.observe(viewLifecycleOwner, Observer {
            Log.d("parityfragment",""+it)
            parityListAdapter.setData(it)
        })
    }


}