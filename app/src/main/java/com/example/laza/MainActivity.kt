package com.example.laza

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.laza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navGraph: NavGraph
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val sharedViewModel: LazaSharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observer()

        // Setup Navigation Drawer toggle with ActionBar
        setupDrawerNavigation()

        // Open Drawer on toolbar button click
        setupToolbarButtonForDrawer()
    }

    private fun observer() {
        sharedViewModel.hideUnNecessaryView.observe(this) { hide ->
            if (hide == true) {
                binding.toolbar.visibility = View.GONE
                binding.bottomNav.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.VISIBLE
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }

    private fun init() {
        // Find the NavHostFragment and NavController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainNavGraph) as NavHostFragment
        navController = navHostFragment.navController
        val navInflater = navController.navInflater
        navGraph = navInflater.inflate(R.navigation.nav_graph)
        navController.graph = navGraph

        // Tie Bottom Navigation with NavController
        binding.bottomNav.setupWithNavController(navController)
    }

    private fun setupDrawerNavigation() {
        // Create AppBarConfiguration with the top-level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(

            ), binding.drawerLayout
        )

        // Set up the ActionBar with NavController and DrawerLayout
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        // Set up the NavigationView with NavController
        binding.navigationDrawer.setupWithNavController(navController)
    }

    private fun setupToolbarButtonForDrawer() {
        binding.toolbar.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    // Handle the ActionBar’s Up button behavior
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController,
            appBarConfiguration
        ) || super.onSupportNavigateUp()
    }

    // Override back press to close drawer if open
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}