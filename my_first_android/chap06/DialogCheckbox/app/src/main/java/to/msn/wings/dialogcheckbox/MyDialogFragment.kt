package to.msn.wings.dialogcheckbox

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val items = arrayOf("電車", "バス", "徒歩", "マイカー", "自転車", "その他")
        // val items = resources.getStringArray(R.array.items)
        val selected = booleanArrayOf(true, true, true, false, false, false)
        val dialog = activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle("通勤手段")
                setIcon(R.drawable.wings)
                setMultiChoiceItems(items, selected) { dialog, which, isChecked ->
                    selected[which] = isChecked
                }
                setPositiveButton("OK") { dialog, which ->
                    val msg = mutableListOf<String>()
                    selected.forEachIndexed { index, e ->
                        if (e) msg.add(items[index])
                    }
                    Toast.makeText(
                        activity,
                        "「${msg.joinToString()}」が選択されました。",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .create()
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}