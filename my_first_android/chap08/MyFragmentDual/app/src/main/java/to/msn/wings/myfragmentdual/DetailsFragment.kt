package to.msn.wings.myfragmentdual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {
    private var isTwoPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            isTwoPane = it.findViewById<FrameLayout>(R.id.detailsFrame) != null
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.details_fragment, container, false)
        (if (isTwoPane) arguments else activity?.intent?.extras)?.let {
            val item = ListDataSource.getInfoByName(it.getString("name"))
            view.findViewById<TextView>(R.id.name).text =
                "${it.getString("name")}（${item["alias"]}）"
            view.findViewById<TextView>(R.id.info).text = item["info"]
        }
        return view
    }
}