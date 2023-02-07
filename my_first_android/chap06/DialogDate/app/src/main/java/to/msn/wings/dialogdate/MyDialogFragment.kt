package to.msn.wings.dialogdate

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val cal = Calendar.getInstance()
        val dialog = activity?.let {
            DatePickerDialog(
                it,
                { view, year, monthOfYear, dayOfMonth ->
                    val txtDate = it.findViewById<EditText>(R.id.txtDate)
                    txtDate.setText("${year}/${monthOfYear + 1}/${dayOfMonth}")
                },
                cal[Calendar.YEAR],
                cal[Calendar.MONTH],
                cal[Calendar.DAY_OF_MONTH]
            )
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}