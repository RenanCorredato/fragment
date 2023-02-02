package com.renancorredato.fragment.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.preference.CheckBoxPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.renancorredato.fragment.R

class PreferenceAppFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        activity?.title = "Configurações"
        setPreferencesFromResource(R.xml.preference_app, rootKey)


// escutando o evento de click progamaticamente
//        val preference = findPreference<Preference>("preferece")
//        preference?.setOnPreferenceClickListener {
//            Toast.makeText(requireContext(),"Toast", Toast.LENGTH_SHORT).show()
//            true
//        }

        val preference = findPreference<CheckBoxPreference>("check_box_preference_1")
        preference?.setOnPreferenceChangeListener { _, newValue ->
           Log.i("Renan","Valor: $newValue")
            true
        }
    }
}