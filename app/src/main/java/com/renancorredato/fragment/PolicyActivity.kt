package com.renancorredato.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class PolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy)

        val valor = intent.extras?.getString("chave", "")

        Log.i("Renan", "Valor: $valor")
    }
}