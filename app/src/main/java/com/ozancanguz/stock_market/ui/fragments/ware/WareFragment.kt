package com.ozancanguz.stock_market.ui.fragments.ware

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentWareBinding


class WareFragment : Fragment() {

    private var _binding: FragmentWareBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWareBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}