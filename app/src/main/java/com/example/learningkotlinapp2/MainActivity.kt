package com.example.learningkotlinapp2

import androidx.appcompat.app.AppCompatActivity
import com.example.learningkotlinapp2.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // This section of the application is used to add the contentView by the use of the DataBinding Utility.

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        // This section of the code is used to add the UP-NAVIGATION in application.
        drawerLayout = binding.drawer
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    // This section of the code is used to add the UP-NAVIGATION in application.
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)

    }
}