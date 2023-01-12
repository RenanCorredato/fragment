package com.renancorredato.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.renancorredato.fragment.databinding.ActivityMainBinding
import com.renancorredato.fragment.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        if (savedInstanceState == null)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<HomeFragment>(R.id.fragmentContainerView)
        }

    }
}