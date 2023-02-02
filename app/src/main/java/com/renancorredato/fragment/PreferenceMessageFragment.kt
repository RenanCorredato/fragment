package com.renancorredato.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class PreferenceMessageFragment: PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
       activity?.title = "Configurações de Mensagens"
        setPreferencesFromResource(R.xml.preference_messagens,rootKey)
    }
}