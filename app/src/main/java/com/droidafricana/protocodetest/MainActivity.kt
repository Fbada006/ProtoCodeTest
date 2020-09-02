package com.droidafricana.protocodetest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.toolbar

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val destinationsList = listOf(R.id.dest_register_fragment, R.id.dest_login_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val host = supportFragmentManager
            .findFragmentById(R.id.nav_container) as NavHostFragment? ?: return

        val navController = host.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in destinationsList) {
                // Hide the toolbar
                toolbar.visibility = View.GONE
            } else toolbar.visibility = View.VISIBLE
        }
    }
}
