package ezlink.project.screentest.View

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import ezlink.project.screentest.R

class Popup {

    companion object {
        fun PopupError(context: Context, msg: String) {
            val li = LayoutInflater.from(context)
            val promptsView: View = li.inflate(R.layout.popup_gagal, null)

            val alertDialogBuilder = AlertDialog.Builder(context)
            alertDialogBuilder.setView(promptsView)
            val alertDialog = alertDialogBuilder.create()

            val message = promptsView.findViewById<TextView>(R.id.message)
            message.setText(msg)

            val btnok = promptsView.findViewById<Button>(R.id.btnok)
            btnok.setOnClickListener { alertDialog.dismiss() }

            alertDialog.show()
            alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        fun PopupSuccess(context: Context, msg: String) {
            val li = LayoutInflater.from(context)
            val promptsView: View = li.inflate(R.layout.popup_informasi, null)

            val alertDialogBuilder = AlertDialog.Builder(context)
            alertDialogBuilder.setView(promptsView)
            val alertDialog = alertDialogBuilder.create()

            val message = promptsView.findViewById<TextView>(R.id.message)
            message.setText(msg)

            val btnok = promptsView.findViewById<Button>(R.id.btnok)
            btnok.setOnClickListener { alertDialog.dismiss() }

            alertDialog.show()
            alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }
}