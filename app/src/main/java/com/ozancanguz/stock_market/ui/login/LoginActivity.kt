package com.ozancanguz.stock_market.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.stock_market.MainActivity
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        FirebaseApp.initializeApp(this)
        // Initialize Firebase Auth
        auth = Firebase.auth

           // user register
             register()

        // user sign in
              signIn()

    }


        private fun register() {

            binding.registerBtn.setOnClickListener {
                val email = binding.emailET.text.toString()
                val password = binding.passwordET.text.toString()

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "E-mail or password empty", Toast.LENGTH_LONG).show()
                } else {

                    auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {

                        Snackbar.make(
                            loginlayout,
                            "User Created.Click on sign in button",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    }.addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG)
                            .show()
                    }


                }
            }

    }
    private fun signIn() {
        binding.signInBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "E-mail or password empty", Toast.LENGTH_LONG)
                    .show()
            } else {

                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                    val intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)

                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }


            }
        }
    }
}