package to.msn.wings.dialogcustom

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = activity?.let {
            val layout = LayoutInflater.from(it)
                .inflate(R.layout.dialog_body, null)
            val txtMsg = layout.findViewById<TextView>(R.id.txtMsg)
            txtMsg.text = arguments?.getString("txtName")

            AlertDialog.Builder(it).apply {
                setTitle("ダイアログの基本")
                setView(layout)
                setIcon(R.drawable.wings)
            }.create()
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}