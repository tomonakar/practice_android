package to.msn.wings.navigationbasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class AfterFragment : Fragment() {
    val args: AfterFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_after, container, false)
        v.findViewById<TextView>(R.id.txtValue)?.apply {
            text = "乱数：${args.num}"
        }
        return v
    }
}