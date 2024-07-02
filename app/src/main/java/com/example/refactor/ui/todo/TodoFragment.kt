package com.example.refactor.ui.todo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.refactor.R
import com.example.refactor.data.entities.Todo
import com.example.refactor.databinding.FragmentTodoBinding
import com.example.refactor.ui.MyViewModel
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import com.prolificinteractive.materialcalendarview.spans.DotSpan
import java.util.Calendar

class TodoFragment : Fragment() {
    private lateinit var myViewModel: MyViewModel
    private lateinit var binding: FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val calendarView: MaterialCalendarView = view.findViewById(R.id.calendarView)

        myViewModel.allTodos.observe(viewLifecycleOwner, Observer { todos ->
                updateCalendarWithTodos(calendarView, todos)
            })
    }

    private fun updateCalendarWithTodos(calendarView: MaterialCalendarView, todos: List<Todo>) {
        calendarView.removeDecorators()
        todos.forEach { todo ->
            val startDate = Calendar.getInstance().apply { time = todo.todoStartDate }
            val endDate = Calendar.getInstance().apply { time = todo.todoEndDate }
            calendarView.addDecorator(TodoDecorator(startDate, endDate))
        }
    }

    class TodoDecorator(private val startDate: Calendar, private val endDate: Calendar) :
        DayViewDecorator {
        override fun shouldDecorate(day: CalendarDay): Boolean {
            val calendarDay = Calendar.getInstance().apply {
                set(day.year, day.month - 1, day.day)
            }
            return !calendarDay.before(startDate) && !calendarDay.after(endDate)
        }

        override fun decorate(view: DayViewFacade) {
            view.addSpan(DotSpan(5f, Color.RED)) // Customize the decoration as needed
        }
    }
}