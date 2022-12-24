package com.ozancanguz.stock_market.ui.fragments.gold

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.data.adapters.GoldListAdapter
import com.ozancanguz.stock_market.databinding.FragmentGoldBinding
import com.ozancanguz.stock_market.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoldFragment : Fragment() {
    private var _binding: FragmentGoldBinding? = null

    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private val mainViewModel:MainViewModel by viewModels()
    private val goldListAdapter=GoldListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGoldBinding.inflate(inflater, container, false)
        val view = binding.root

        FirebaseApp.initializeApp(requireContext())
        // Initialize Firebase Auth
        auth = Firebase.auth

        setHasOptionsMenu(true)

        // setup rv
        setupRv()

        // update ui
        observeLiveData()

        return view
    }

    private fun setupRv() {
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=goldListAdapter
    }

    private fun observeLiveData() {
        mainViewModel.requestGoldPrices()
        mainViewModel.goldPriceList.observe(viewLifecycleOwner, Observer {
            goldListAdapter.setData(it)
        })
    }


    // create menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.signoutmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    // menu onclick listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.signOutMenuu){
            auth.signOut()
            findNavController().navigate(R.id.action_goldFragment_to_loginActivity)
            Toast.makeText(requireContext(),"Succesfully signout",Toast.LENGTH_LONG).show()
            
        }
        return super.onOptionsItemSelected(item)
    }


}