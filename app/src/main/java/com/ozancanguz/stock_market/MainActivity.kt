package com.ozancanguz.stock_market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import androidx.navigation.ui.AppBarConfiguration

import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.stock_market.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.android.synthetic.main.activity_main.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)
        // Initialize Firebase Auth
        auth = Firebase.auth

        navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.goldFragment,
                R.id.cryptoFragment,
                R.id.stockFragment,
                R.id.parityFragment,
                R.id.wareFragment
            )
        )

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.signoutmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }


        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if(item.itemId==R.id.signOutMenuu){
                auth.signOut()
              val intent= Intent(this,LoginActivity::class.java)
                startActivity(intent)


            }
            return super.onOptionsItemSelected(item)
        }


    }



