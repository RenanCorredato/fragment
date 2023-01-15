package com.renancorredato.fragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
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

        binding.home.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HomeFragment>(binding.fragmentContainerView.id)
                addToBackStack(null)
            }
        }

        binding.register.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<RegisterFragment>(binding.fragmentContainerView.id)
                addToBackStack(null)
            }
        }

        binding.logs.setOnClickListener {

            supportFragmentManager.popBackStack()
 //           showBackstackFragments()

        }
    }

    private fun showBackstackFragments() {
        Log.i("Renan", "-----------------------------------------------------------------------")
        supportFragmentManager.fragments.forEach {
            Log.i("Renan", it.toString())
        }
    }
}