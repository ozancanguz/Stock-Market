package com.ozancanguz.stock_market.ui.fragments.gold

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.FragmentGoldBinding


class GoldFragment : Fragment() {
    private var _binding: FragmentGoldBinding? = null

    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


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
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.signoutmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.signOutMenuu){
            auth.signOut()
            findNavController().navigate(R.id.action_goldFragment_to_loginActivity)
            Toast.makeText(requireContext(),"Succesfully signout",Toast.LENGTH_LONG).show()
            
        }
        return super.onOptionsItemSelected(item)
    }


}