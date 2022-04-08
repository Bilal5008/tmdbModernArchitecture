package com.structure.tmdb.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.structure.tmdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the bottom navigation view
        //create bottom navigation view object
        val navController = Navigation.findNavController(this, R.id.nav_fragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

    }
}