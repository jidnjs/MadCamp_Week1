package com.example.madcamp_week1.ui.todo

import android.app.DatePickerDialog
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.trace
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.madcamp_week1.R
import com.example.madcamp_week1.data.entities.Group
import com.example.madcamp_week1.data.entities.Todo
import com.example.madcamp_week1.ui.MyViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class AddTodoDialogFragment : DialogFragment() {

    private lateinit var myViewModel: MyViewModel
    private lateinit var allGroups: List<Group>

    companion object {
        private const val ARG_DEFAULT_DATE = "default_date"
        const val REQUEST_KEY = "add_todo_request"
        const val BUNDLE_KEY = "new_todo"
        private const val TIME_PICKER_INTERVAL = 5

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
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        val todoName = view.findViewById<EditText>(R.id.todoName)
        val todoContent = view.findViewById<EditText>(R.id.todoContent)
        val todoDay = view.findViewById<EditText>(R.id.todoDay)
        val timePicker = view.findViewById<TimePicker>(R.id.timePicker)
        val groupSpinner = view.findViewById<Spinner>(R.id.groupSpinner)
        val saveButton = view.findViewById<Button>(R.id.saveButton)
        setTimePickerInterval(timePicker)
        myViewModel.allGroups.observe(viewLifecycleOwner) { groups ->
            allGroups = groups
            setupGroupSpinner(groupSpinner!!)
        }

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
            val name = todoName.text.toString()
            val content = todoContent.text.toString()

            if (name.isBlank()) {
                Toast.makeText(requireContext(), "Please enter valid name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(groupSpinner.selectedItemPosition == -1) {
                Toast.makeText(requireContext(), "Please select group", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val dateTimeString = "${todoDay.text.toString()} ${timePicker.hour}:${timePicker.minute}"
            val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
            val combinedDateTime: Date? = dateTimeFormat.parse(dateTimeString)

            val newTodo = Todo(
                todoName = name,
                todoContent = content,
                todoDate = combinedDateTime!!,
                groupId = allGroups[groupSpinner.selectedItemPosition].groupId
            )

            returnTodoToParentFragment(newTodo)
            dismiss()
        }
    }

    private fun setupGroupSpinner(groupSpinner: Spinner) {
        val groupNames = allGroups.map { it.groupName }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, groupNames).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        groupSpinner.adapter = adapter
    }

    private fun returnTodoToParentFragment(todo: Todo) {
        val result = Bundle().apply {
            putSerializable(BUNDLE_KEY, todo)
        }
        requireActivity().supportFragmentManager.setFragmentResult(REQUEST_KEY, result)
    }

    private fun setTimePickerInterval(timePicker: TimePicker) {
        try {
            val minutePicker = timePicker.findViewById<View>(
                Resources.getSystem().getIdentifier(
                    "minute", "id", "android"
                )
            ) as NumberPicker
            minutePicker.minValue = 0
            minutePicker.maxValue = 60 / TIME_PICKER_INTERVAL - 1
            val displayedValues: MutableList<String> = ArrayList()
            var i = 0
            while (i < 60) {
                displayedValues.add(String.format("%02d", i))
                i += TIME_PICKER_INTERVAL
            }
            minutePicker.displayedValues = displayedValues.toTypedArray<String>()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}
