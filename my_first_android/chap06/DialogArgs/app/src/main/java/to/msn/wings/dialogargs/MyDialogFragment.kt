package to.msn.wings.dialogargs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            val txtName = arguments?.getString("txtName")
            AlertDialog.Builder(it).apply {
                setTitle("ダイアログの基本")
                setMessage("こんにちは、${txtName}さん！")
                setIcon(R.drawable.wings)
            }.create()
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}