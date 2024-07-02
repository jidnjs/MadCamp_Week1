package com.example.refactor.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.refactor.R
import com.example.refactor.ui.adapters.TodoAdapter
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import java.util.Calendar
import java.util.Date

class TodoFragment : Fragment() {

    private lateinit var calendarView: MaterialCalendarView
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

        calendarView.setOnDateChangedListener(OnDateSelectedListener { _, date, _ ->
            val calendar = Calendar.getInstance()
            calendar.set(date.year, date.month - 1, date.day)
            selectedDate = calendar.time
        })

        addTodoButton.setOnClickListener {
            val addTodoDialog = AddTodoDialogFragment.newInstance(selectedDate)
            addTodoDialog.show(parentFragmentManager, "AddTodoDialogFragment")
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        val today = CalendarDay.today()
        calendarView.setSelectedDate(today)  // Ensure the calendar highlights today's date
        calendarView.setCurrentDate(today)   // Ensure the calendar shows today's month
        val calendar = Calendar.getInstance()
        selectedDate = calendar.time
    }
}
