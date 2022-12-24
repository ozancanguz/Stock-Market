package com.ozancanguz.stock_market.ui.fragments.parity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentParityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParityFragment : Fragment() {
    private var _binding: FragmentParityBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParityBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }


}