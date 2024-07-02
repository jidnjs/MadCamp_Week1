package com.example.refactor.ui.contact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import com.example.refactor.R
import com.example.refactor.data.entities.Contact
import com.example.refactor.data.entities.Group
import com.example.refactor.databinding.DialogGroupSelectionBinding
import com.example.refactor.ui.MyViewModel

class GroupSelectionDialogFragment : DialogFragment() {

    private lateinit var binding: DialogGroupSelectionBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var allGroups: List<Group>
    private lateinit var listViewGroups: ListView
    private lateinit var currentContact: Contact
    private var contactId: Long = 0L
    private lateinit var selectedGroupIds: List<Long>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogGroupSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        contactId = arguments?.getLong("contactId") ?: 0L

        listViewGroups = binding.listViewGroups

        myViewModel.getContactByContactId(contactId).observe(viewLifecycleOwner) { contact ->
            if (contact != null) {
                currentContact = contact
                selectedGroupIds = contact.groupIdList
                myViewModel.allGroups.observe(viewLifecycleOwner) { groups ->
                    allGroups = groups
                }
                setupGroupListView()
            }
        }

        binding.btnDone.setOnClickListener {
            val selectedGroupIdList = getSelectedGroupIdList()
            returnSelectedGroupsToContactDetailFragment(selectedGroupIdList)
            dismiss()
        }
    }

    private fun setupGroupListView() {
//        val groupNames = allGroups.map { it.groupName }
//        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_multiple_choice, groupNames)
//        listViewGroups.adapter = adapter
        val groupNames = allGroups.map { it.groupName }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_multiple_choice, groupNames)
        listViewGroups.adapter = adapter
        listViewGroups.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        // Check the items that are in the selectedGroups list
        allGroups.forEachIndexed { index, group ->
            if (selectedGroupIds.contains(group.groupId)) {
                listViewGroups.setItemChecked(index, true)
            }
        }
    }

    private fun getSelectedGroupIdList(): List<Long> {
        val selectedGroups = mutableListOf<Long>()
        for (i in 0 until listViewGroups.count) {
            if (listViewGroups.isItemChecked(i)) {
                selectedGroups.add(allGroups[i].groupId)
            }
        }
        return selectedGroups
    }

    private fun returnSelectedGroupsToContactDetailFragment(selectedGroups: List<Long>) {
        val result = Bundle().apply {
            putLongArray("selectedGroupIdList", selectedGroups.toLongArray())
        }
        requireActivity().supportFragmentManager.setFragmentResult("GSkey", result)
    }
}
