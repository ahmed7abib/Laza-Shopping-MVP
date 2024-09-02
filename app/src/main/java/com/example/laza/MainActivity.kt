package com.example.laza

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.example.laza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navGraph: NavGraph
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    private val sharedViewModel: LazaSharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observer()
    }

    private fun observer() {
        sharedViewModel.hideUnNecessaryView.observe(this) { hide ->
            if (hide == true) {
                binding.toolbar.visibility = View.GONE
                binding.bottomNav.visibility = View.GONE
            }
        }
    }

    private fun init() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainNavGraph) as NavHostFragment

        navController = navHostFragment.navController
        val navInflater = navController.navInflater
        navGraph = navInflater.inflate(R.navigation.nav_graph)
        navController.graph = navGraph
    }
}