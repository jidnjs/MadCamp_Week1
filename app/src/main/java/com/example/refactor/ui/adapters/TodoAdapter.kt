package com.example.refactor.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.refactor.R
import com.example.refactor.data.entities.Todo

class TodoAdapter(private var todoList: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoName: TextView = itemView.findViewById(R.id.todoName)
        val todoContent: TextView = itemView.findViewById(R.id.todoContent)
        val todoDate: TextView = itemView.findViewById(R.id.todoDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.todoName.text = todo.todoName
        holder.todoContent.text = todo.todoContent
        holder.todoDate.text = todo.todoDate.toString() // Format date as needed
    }

    override fun getItemCount() = todoList.size

    fun updateTodoList(newTodoList: List<Todo>) {
        todoList = newTodoList
        notifyDataSetChanged()
    }
}
