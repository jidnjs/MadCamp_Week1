package com.example.refactor.ui.group

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.refactor.R
import com.example.refactor.data.entities.Group
import com.example.refactor.databinding.FragmentGroupBinding
import com.example.refactor.ui.MyViewModel
import com.example.refactor.ui.adapters.GroupTodoAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GroupFragment : Fragment() {

    private lateinit var binding: FragmentGroupBinding
    private lateinit var groupTodoAdapter: GroupTodoAdapter
    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        val groupId = arguments?.getLong("groupId")
        val groupName = arguments?.getString("groupName")

        if (groupId != null) {
            myViewModel.getGroupByGroupId(groupId).observe(viewLifecycleOwner, Observer{ group ->
                if (group != null) {
                    setupRecyclerView(group)
                }
            })

            binding.gotoImageGroupButton.setOnClickListener {
                val bundle = Bundle().apply {
                    putLong("groupId", groupId)
                }
                it.findNavController().navigate(R.id.action_groupFragment_to_galleryAlbumFragment, bundle)
            }
        }

        binding.groupDetailsTitle.text = groupName

        binding.removeGroupButton.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Delete $groupName group")
                .setMessage("Do you want to delete this group?")
                .setPositiveButton("Confirm") { _, _ ->
                    if (groupId != null) {
                        myViewModel.deleteGroup(groupId)
                    }
                    findNavController().navigateUp()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
//        binding.gotoContactGroupButton.setOnClickListener {
//            findNavController().navigate(R.id.action_groupDetailFragment_to_contactFragment)
//        }
//
//        binding.gotoImageGroupButton.setOnClickListener {
//            findNavController().navigate(R.id.action_groupDetailFragment_to_galleryFragment)
//        }
//
//        binding.gotoTodoGroupButton.setOnClickListener {
//            findNavController().navigate(R.id.action_groupDetailFragment_to_todoFragment)
//        }
    }

    private fun setupRecyclerView(group: Group) {
        groupTodoAdapter = GroupTodoAdapter(myViewModel, requireActivity())
        binding.todoList.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = groupTodoAdapter
        }
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback())
        itemTouchHelper.attachToRecyclerView(binding.todoList)

        myViewModel.allTodos.observe(viewLifecycleOwner, Observer{ todos ->
            groupTodoAdapter.submitList(todos.filter{
                it.groupId == group.groupId
            }.sortedBy { it.todoDate })
            groupTodoAdapter.notifyDataSetChanged()
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
            groupTodoAdapter.deleteItem(position)
        }
    }
}