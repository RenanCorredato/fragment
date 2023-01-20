package com.renancorredato.fragment

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.MenuProvider
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.renancorredato.fragment.databinding.ActivityMainBinding
import com.renancorredato.fragment.fragments.HomeFragment
import com.renancorredato.fragment.fragments.RegisterFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //desativar action em um layout
        supportActionBar?.hide()

//        setupActionBar()
//
//    }
//
//    private fun setupActionBar() {
//        addMenuProvider(object : MenuProvider {
//            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//                menuInflater.inflate(R.menu.menu_home, menu)
//            }
//
//            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
////                Log.i("Renan",menuItem.title.toString())
//                when (menuItem.itemId) {
//                    R.id.action_salve -> {
////                        save()
//                    }
//
//                    R.id.action_setting -> {
//                        menuItem.isCheckable = !menuItem.isCheckable
//                    }
//                }
//
//                return true
//            }
//
//        })
//    }
//
////    private fun openSetting() {
////        TODO("Not yet implemented")
////    }
////
////    private fun save() {
////        TODO("Not yet implemented")
////    }
    }
}
