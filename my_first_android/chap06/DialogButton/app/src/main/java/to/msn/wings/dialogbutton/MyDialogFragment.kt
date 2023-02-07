package to.msn.wings.dialogbutton

import android.app.AlertDialog
import android.app.Dialog
// import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {

    /*
    // ひとつのリスナーにまとめた場合
    val listener = DialogInterface.OnClickListener { dialog, which ->
        when (which) {
            DialogInterface.BUTTON_POSITIVE -> Toast.makeText(activity, "正解です！",
                Toast.LENGTH_SHORT).show()
            DialogInterface.BUTTON_NEGATIVE -> Toast.makeText(activity, "ミス",
                Toast.LENGTH_SHORT).show()
            DialogInterface.BUTTON_NEUTRAL  -> {}
        }
    }
    */

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle("ダイアログの基本")
                setMessage("AndroidはJavaで開発できますか？")
                setIcon(R.drawable.wings)
                setPositiveButton("はい") { dialog, which ->
                    Toast.makeText(activity, "正解です！", Toast.LENGTH_SHORT)
                        .show()
                }
                setNegativeButton("いいえ") { dialog, which ->
                    Toast.makeText(activity, "ミス！", Toast.LENGTH_SHORT)
                        .show()
                }
                setNeutralButton("キャンセル") { dialog, which -> }

                /*
                setPositiveButton("はい", listener)
                setNegativeButton("いいえ", listener)
                setNeutralButton("キャンセル", listener)
                */

            }
                .create()
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}