package com.example.refactor.ui

import android.app.Dialog
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.refactor.R
import java.util.Calendar

class AddTodoDialogFragment(private val selectedDate: Long) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_add_todo)

        val todoName = dialog.findViewById<EditText>(R.id.todoName)
        val todoContent = dialog.findViewById<EditText>(R.id.todoContent)
        val todoDay = dialog.findViewById<TextView>(R.id.todoDay)
        val todoHour = dialog.findViewById<EditText>(R.id.todoHour)
        val todoMin = dialog.findViewById<EditText>(R.id.todoMin)
        val groupSpinner = dialog.findViewById<Spinner>(R.id.groupSpinner)
        val saveButton = dialog.findViewById<Button>(R.id.saveButton)

        val cal = Calendar.getInstance().apply { timeInMillis = selectedDate }
        todoDay.text = "${cal.get(Calendar.YEAR)}/${cal.get(Calendar.MONTH) + 1}/${cal.get(Calendar.DAY_OF_MONTH)}"

        saveButton.setOnClickListener {
            // Save Todo logic here
            dismiss()
        }

        return dialog
    }
}
