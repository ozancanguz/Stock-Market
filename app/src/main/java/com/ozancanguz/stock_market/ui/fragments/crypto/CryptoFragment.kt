package com.ozancanguz.stock_market.ui.fragments.crypto

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.data.adapters.CryptoAdapter
import com.ozancanguz.stock_market.databinding.FragmentCryptoBinding
import com.ozancanguz.stock_market.viewmodels.CryptoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoFragment : Fragment() {
    private var _binding: FragmentCryptoBinding? = null

    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

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

        FirebaseApp.initializeApp(requireContext())
        // Initialize Firebase Auth
        auth = Firebase.auth

        setHasOptionsMenu(true)

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