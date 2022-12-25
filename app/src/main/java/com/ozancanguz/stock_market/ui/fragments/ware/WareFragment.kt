package com.ozancanguz.stock_market.ui.fragments.ware

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentWareBinding
import com.ozancanguz.stock_market.viewmodels.WareViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WareFragment : Fragment() {

    private var _binding: FragmentWareBinding? = null
    private val binding get() = _binding!!


    private val wareViewModel:WareViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWareBinding.inflate(inflater, container, false)
        val view = binding.root

        // observe live data and update ui
          observeLiveData()



        return view
    }

    private fun observeLiveData() {
        wareViewModel.requestWareData()
        wareViewModel.wareList.observe(viewLifecycleOwner, Observer {
            Log.d("warefragment"," "+it)
        })
    }


}