package com.example.refactor.ui.todo

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.refactor.R
import com.example.refactor.data.entities.Todo
import java.util.*

class AddTodoDialogFragment : DialogFragment() {

    companion object {
        private const val ARG_DEFAULT_DATE = "default_date"

        fun newInstance(defaultDate: Date?): AddTodoDialogFragment {
            val fragment = AddTodoDialogFragment()
            val args = Bundle().apply {
                putSerializable(ARG_DEFAULT_DATE, defaultDate)
            }
            fragment.arguments = args
            return fragment
        }
    }

    private var defaultDate: Date? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            defaultDate = it.getSerializable(ARG_DEFAULT_DATE) as? Date
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_add_todo, container, false)
        val todoName = view.findViewById<EditText>(R.id.todoName)
        val todoContent = view.findViewById<EditText>(R.id.todoContent)
        val todoDay = view.findViewById<EditText>(R.id.todoDay)
        val timePicker = view.findViewById<TimePicker>(R.id.timePicker)
        val groupSpinner = view.findViewById<Spinner>(R.id.groupSpinner)
        val saveButton = view.findViewById<Button>(R.id.saveButton)

        timePicker.setIs24HourView(true)

        defaultDate?.let {
            val calendar = Calendar.getInstance()
            calendar.time = it
            todoDay.setText("${calendar.get(Calendar.YEAR)}-${calendar.get(Calendar.MONTH) + 1}-${calendar.get(Calendar.DAY_OF_MONTH)}")
        }

        todoDay.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->
                todoDay.setText("$year-${month + 1}-$dayOfMonth")
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        saveButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.time = defaultDate ?: Date()
            calendar.set(Calendar.HOUR_OF_DAY, timePicker.hour)
            calendar.set(Calendar.MINUTE, timePicker.minute)

            val newTodo = Todo(
                todoName = todoName.text.toString(),
                todoContent = todoContent.text.toString(),
                todoDate = calendar.time,
                forallDay = false,
//                groupName = groupSpinner.selectedItem.toString()
                groupId = 1
            )

            // Save the newTodo object to the database or update the list
            dismiss()
        }

        return view
    }
}
