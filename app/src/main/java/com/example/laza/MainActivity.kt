package com.example.laza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.common.gone
import com.example.common.visible
import com.example.laza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
        setUpBottomNav()
        setupBurgerMenuButton()
    }

    private fun onClick() {
        binding.sideMenuId.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun setUpBottomNav() {
        navController = findNavController(R.id.mainNavGraph)
        binding.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> hideUnNecessaryView()
                R.id.loginFragment -> hideUnNecessaryView()
                R.id.forgotPasswordFragment -> hideUnNecessaryView()
                R.id.signUpFragment -> hideUnNecessaryView()
                R.id.accountCreationChooserFragment -> hideUnNecessaryView()
                R.id.confirmPasswordFragment -> hideUnNecessaryView()
                R.id.changePasswordFragment -> hideUnNecessaryView()

                else -> showUnNecessaryView()
            }
        }
    }

    private fun hideUnNecessaryView() {
        binding.toolbar.gone()
        binding.bottomNav.gone()
    }

    private fun showUnNecessaryView() {
        binding.toolbar.visible()
        binding.bottomNav.visible()
    }

    private fun setupBurgerMenuButton() {
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.settingsFragment),
            binding.drawerLayout
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController,
            binding.drawerLayout
        ) || super.onSupportNavigateUp()
    }
}

