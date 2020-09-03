package com.droidafricana.protocodetest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val destinationsList = listOf(
        R.id.dest_register_fragment,
        R.id.dest_login_fragment
    )

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val host = supportFragmentManager
            .findFragmentById(R.id.nav_container) as NavHostFragment? ?: return

        navController = host.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.dest_lpg_products_fragment
            )
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in destinationsList) {
                toolbar.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
                toolbar.title = destination.label
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}
