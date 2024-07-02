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
import com.example.refactor.ui.AddTodoDialogFragment
import com.example.refactor.ui.adapters.TodoAdapter
import java.util.*

class TodoFragment : Fragment() {

    private lateinit var calendarView: CalendarView
    private lateinit var addTodoButton: Button
    private lateinit var recyclerViewTodos: RecyclerView
    private lateinit var todoAdapter: TodoAdapter
    private var selectedDate: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo, container, false)

        calendarView = view.findViewById(R.id.calendarView)
        addTodoButton = view.findViewById(R.id.addTodoButton)
        recyclerViewTodos = view.findViewById(R.id.recyclerViewTodos)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todoAdapter = TodoAdapter()
        recyclerViewTodos.layoutManager = LinearLayoutManager(context)
        recyclerViewTodos.adapter = todoAdapter

        // Add some dummy data to the adapter
        val dummyTodos = listOf(
            Todo(
                todoName = "Sample Todo 1",
                todoContent = "This is a sample todo",
                todoDate = Date(),
                groupId = 1
            ),
            Todo(
                todoName = "Sample Todo 2",
                todoContent = "This is another sample todo",
                todoDate = Date(),
                groupId = 1
            )
        )
        todoAdapter.setTodos(dummyTodos)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
            selectedDate = cal.timeInMillis
        }

        addTodoButton.setOnClickListener {
            showAddTodoDialog()
        }
    }

    override fun onResume() {
        super.onResume()
        calendarView.date = Calendar.getInstance().timeInMillis
    }

    private fun showAddTodoDialog() {
        val dialog = AddTodoDialogFragment(selectedDate)
        dialog.show(childFragmentManager, "AddTodoDialogFragment")
    }
}
