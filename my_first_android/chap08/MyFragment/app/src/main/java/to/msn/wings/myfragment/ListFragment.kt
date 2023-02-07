package to.msn.wings.myfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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
                    fragment.arguments = Bundle().apply {
                        putString("name", parent.getItemAtPosition(pos).toString())
                    }
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.detailsFrame, fragment)
                        .commit()
                }
            }
        }
    return view
   }
}
