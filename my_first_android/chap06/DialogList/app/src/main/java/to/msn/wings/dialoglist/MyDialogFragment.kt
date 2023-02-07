package to.msn.wings.dialoglist

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val items = arrayOf("A型", "B型", "O型", "AB型")
        val dialog = activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle("血液型")
                setIcon(R.drawable.wings)
                setItems(items) { dialog, which ->
                    Toast.makeText(
                        activity, "「${items[which]}」が選択されました。",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.create()
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}