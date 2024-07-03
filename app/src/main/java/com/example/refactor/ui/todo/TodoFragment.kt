package com.example.refactor.ui.todo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.refactor.R
import com.example.refactor.data.entities.Group
import com.example.refactor.data.entities.Todo
import com.example.refactor.databinding.FragmentTodoBinding
import com.example.refactor.ui.MyViewModel
import com.example.todo.ui.adapters.TodoAdapter
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import java.util.Calendar
import java.util.Date

class TodoFragment : Fragment() {

    private lateinit var binding: FragmentTodoBinding
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var myViewModel: MyViewModel
    private var selectedDate: Date? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        setupRecyclerView()

        requireActivity().supportFragmentManager.setFragmentResultListener(
            AddTodoDialogFragment.REQUEST_KEY,
            this
        ) { _, bundle ->
            val newTodo = bundle.getSerializable(AddTodoDialogFragment.BUNDLE_KEY) as Todo
            myViewModel.addTodo(newTodo)
        }

        binding.calendarView.setOnDateChangedListener(OnDateSelectedListener { _, date, _ ->
            val calendar = Calendar.getInstance()
            calendar.set(date.year, date.month - 1, date.day)
            selectedDate = calendar.time
        })

        binding.addTodoButton.setOnClickListener {
            val addTodoDialog = AddTodoDialogFragment.newInstance(selectedDate)
            addTodoDialog.show(parentFragmentManager, "AddTodoDialogFragment")
        }
    }

    override fun onResume() {
        super.onResume()
        val today = CalendarDay.today()
        binding.calendarView.apply {
            setSelectedDate(today) // Ensure the calendar highlights today's date
            setCurrentDate(today)// Ensure the calendar shows today's month
        }
        val calendar = Calendar.getInstance()
        selectedDate = calendar.time
    }

    private fun setupRecyclerView() {
        todoAdapter  = TodoAdapter(myViewModel, requireActivity())
        binding.todoFragmentRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoAdapter
        }
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback())
        itemTouchHelper.attachToRecyclerView(binding.todoFragmentRecyclerView)

        myViewModel.allTodos.observe(viewLifecycleOwner, Observer { todos ->
            todoAdapter.submitList(todos.sortedBy { it.todoDate } )
            todoAdapter.notifyDataSetChanged()
        })
    }

    private inner class SwipeToDeleteCallback : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            todoAdapter.deleteItem(position)
        }
    }
}
