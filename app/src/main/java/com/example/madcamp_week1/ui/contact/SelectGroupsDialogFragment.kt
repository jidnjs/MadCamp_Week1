package com.example.madcamp_week1.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.madcamp_week1.data.entities.Contact
import com.example.madcamp_week1.data.entities.Group
import com.example.madcamp_week1.databinding.DialogSelectGroupsBinding
import com.example.madcamp_week1.ui.MyViewModel

class SelectGroupsDialogFragment : DialogFragment() {

    private lateinit var binding: DialogSelectGroupsBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var allGroups: List<Group>
    private lateinit var listViewGroups: ListView
    private lateinit var currentContact: Contact
    private var contactId: Long = 0L
    private lateinit var selectedGroupIds: List<Long>

    companion object {
        private const val ARG_DEFAULT_DATE = "default_date"
        const val REQUEST_KEY = "select_groups_request"
        const val BUNDLE_KEY = "selected_group_id_list"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogSelectGroupsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        contactId = arguments?.getLong("contactId") ?: 0L
        selectedGroupIds = arguments?.getLongArray("selectedGroupIds")?.toList()?: listOf()

        listViewGroups = binding.listViewGroups

        myViewModel.getContactByContactId(contactId).observe(viewLifecycleOwner) { contact ->
            if (contact != null) {
                currentContact = contact
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
            putLongArray(BUNDLE_KEY, selectedGroups.toLongArray())
        }
        requireActivity().supportFragmentManager.setFragmentResult(REQUEST_KEY, result)
    }
}
