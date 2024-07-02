package com.example.refactor.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.refactor.R
import com.example.refactor.data.entities.Todo
import com.example.refactor.ui.adapters.TodoAdapter
import java.util.*

class TodoFragment : Fragment() {

    private lateinit var calendarView: CalendarView
    private lateinit var addTodoButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var todoAdapter: TodoAdapter
    private var selectedDate: Date? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo, container, false)

        calendarView = view.findViewById(R.id.calendarView)
        addTodoButton = view.findViewById(R.id.addTodoButton)
        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        todoAdapter = TodoAdapter(listOf())
        recyclerView.adapter = todoAdapter

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            selectedDate = calendar.time
        }

        addTodoButton.setOnClickListener {
            val addTodoDialog = AddTodoDialogFragment.newInstance(selectedDate)
            addTodoDialog.show(parentFragmentManager, "AddTodoDialogFragment")
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        calendarView.date = System.currentTimeMillis()
    }
}
