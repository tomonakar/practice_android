package to.msn.wings.myfragmentdual

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private var isTwoPane = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isTwoPane = activity?.findViewById<FrameLayout>(R.id.detailsFrame) != null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        activity?.let {
            view.findViewById<ListView>(R.id.list).apply {
                adapter = ArrayAdapter(
                    it,
                    android.R.layout.simple_list_item_1,
                    ListDataSource.getAllNames()
                )
                setOnItemClickListener { parent, view, pos, id ->
                    val fragment = DetailsFragment()
                    val bundle = Bundle().apply {
                        putString("name", parent.getItemAtPosition(pos).toString())
                    }

                    if (isTwoPane) {
                        fragment.arguments = bundle
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.detailsFrame, fragment)
                            .commit()
                    } else {
                        startActivity(
                            Intent(it, DetailsActivity::class.java).apply {
                                putExtras(bundle)
                            }
                        )
                    }
                }
            }
        }
        return view
    }
}