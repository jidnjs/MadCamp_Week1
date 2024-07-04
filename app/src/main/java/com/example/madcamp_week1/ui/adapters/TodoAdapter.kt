package com.example.todo.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.data.entities.Todo
import com.example.madcamp_week1.databinding.ItemTodoBinding
import com.example.madcamp_week1.R
import com.example.madcamp_week1.ui.MyViewModel
import java.text.SimpleDateFormat

class TodoAdapter(
    private val myViewModel: MyViewModel,
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<Todo, TodoAdapter.TodoViewHolder>(TodoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = getItem(position)
        holder.bind(todo)
    }

    inner class TodoViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo) {
            myViewModel.getGroupByGroupId(todo.groupId).observe(lifecycleOwner, Observer{ group ->
                if(group!=null) binding.tvGroupName.text = "${group!!.groupName}"
            })
            binding.tvTodoName.text = todo.todoName
            val dayFormat = SimpleDateFormat("yyyy-MM-dd")
            val timeFormat = SimpleDateFormat("HH:mm")
            binding.tvTodoDay.text = "${dayFormat.format(todo.todoDate)}"
            binding.tvTodoTime.text = "${timeFormat.format(todo.todoDate)}"
            binding.tvTodoContent.text = todo.todoContent
        }
    }

    fun deleteItem(position: Int) {
        val todo = getItem(position)
        myViewModel.deleteTodo(todo)
    }
}

class TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.todoId == newItem.todoId
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }
}
