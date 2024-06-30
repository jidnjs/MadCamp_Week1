package com.example.madcamp_week1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityMainBinding
import com.example.madcamp_week1.repository.DatabaseManager
import com.example.madcamp_week1.repository.Repository
import com.example.madcamp_week1.repository.RepositoryImpl
import com.example.madcamp_week1.ui.fragment.ContactsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var repository: Repository  // Delay the initialization
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate and set the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize DatabaseManager with the current context
        DatabaseManager.init(this)

        // Instantiate RepositoryImpl after DatabaseManager is initialized
        repository = RepositoryImpl()
//
//        assert(false)
//        // Set up the ContactsFragment with the repository
//        if (savedInstanceState == null) { // Check to ensure this only happens once on creation
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment_activity_main   , ContactsFragment(repository))
//                .commit()
//        }


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_contacts
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}