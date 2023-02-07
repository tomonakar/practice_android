package to.msn.wings.dialogbasic

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle("ダイアログの基本")
                // setTitle(R.string.d_title)
                setMessage("こんにちは、世界！")
                setIcon(R.drawable.wings)
            }.create()
        }
    return dialog ?: throw IllegalStateException("Activity is null.")
    }
}