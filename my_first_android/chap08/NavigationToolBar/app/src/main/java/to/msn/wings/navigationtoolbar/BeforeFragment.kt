package to.msn.wings.navigationtoolbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class BeforeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_before, container, false)
        view.findViewById<Button>(R.id.btnNext).setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.afterFragment)
        }
        return view
    }
}