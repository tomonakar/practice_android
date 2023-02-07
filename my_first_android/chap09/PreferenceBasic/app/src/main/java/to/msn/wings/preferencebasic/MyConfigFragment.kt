package to.msn.wings.preferencebasic

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class MyConfigFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(
        savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref)
    }
}
