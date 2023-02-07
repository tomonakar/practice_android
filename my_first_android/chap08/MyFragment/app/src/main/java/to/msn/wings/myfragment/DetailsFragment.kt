package to.msn.wings.myfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.details_fragment, container, false)
        arguments?.let {
            val item = ListDataSource.getInfoByName(it.getString("name"))
            view.findViewById<TextView>(R.id.name).text =
                "${it.getString("name")}（${item["alias"]}）"
            view.findViewById<TextView>(R.id.info).text = item["info"]
        }
        return view
    }
}