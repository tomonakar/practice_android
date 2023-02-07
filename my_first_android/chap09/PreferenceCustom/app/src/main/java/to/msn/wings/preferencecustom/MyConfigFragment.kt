package to.msn.wings.preferencecustom

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class MyConfigFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(
        savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref)
    }
}