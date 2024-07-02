package com.example.refactor.ui.group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.refactor.databinding.FragmentGroupBinding
import com.example.refactor.ui.MyViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GroupFragment : Fragment() {

    private lateinit var binding: FragmentGroupBinding
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
    }
}