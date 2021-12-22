package com.mintic.PopayanTravel

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class PrimaryPref_Frag : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.pref_fragment, rootKey)
    }
}

