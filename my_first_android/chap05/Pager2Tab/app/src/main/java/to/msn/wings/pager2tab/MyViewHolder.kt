package to.msn.wings.pager2tab

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
    val imgPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
}