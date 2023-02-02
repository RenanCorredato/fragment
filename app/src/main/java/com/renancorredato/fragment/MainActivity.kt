package com.renancorredato.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.renancorredato.fragment.databinding.ActivityMainBinding
import com.renancorredato.fragment.fragments.PreferenceAppFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupMenu()
    }

    private fun setupMenu() {
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_home, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean = when (menuItem.itemId) {
                R.id.action_setting -> {
                    openSettings()
                    true
                }
                else -> false
            }
        })
    }

    private fun openSettings() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<PreferenceAppFragment>(binding.fragmentContainerView.id)
            addToBackStack(null)
        }
    }

}