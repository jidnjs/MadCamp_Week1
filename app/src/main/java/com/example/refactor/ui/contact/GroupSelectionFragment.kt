package com.example.refactor.ui.contact

// Import necessary libraries
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.refactor.R
import com.example.refactor.data.entities.Contact
import com.example.refactor.data.entities.Group
import com.example.refactor.databinding.FragmentGroupSelectionBinding
import com.example.refactor.ui.MyViewModel

class GroupSelectionFragment : Fragment() {

    private lateinit var binding: FragmentGroupSelectionBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var allGroups: List<Group>
    private lateinit var listViewGroups: ListView
    private lateinit var currentContact: Contact
    private var contactId: Long = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupSelectionBinding.inflate(inflater, container, false)
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
                myViewModel.allGroups.observe(viewLifecycleOwner) { groups ->
                    allGroups = groups
                    setupGroupListView(groups)
                }
            }
        }

        binding.btnDone.setOnClickListener {
            val selectedGroupIdList = getSelectedGroupIdList()
            returnSelectedGroupsToContactDetailFragment(selectedGroupIdList)
            findNavController().popBackStack()
        }
    }

    private fun setupGroupListView(groups: List<Group>) {
        val groupNames = groups.map { it.groupName }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_multiple_choice, groupNames)
        listViewGroups.adapter = adapter
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
        setFragmentResult("requestKey", result)
    }


//    private fun updateContactWithSelectedGroups(selectedGroups: List<Group>) {
//        val updatedContact = currentContact.copy(
//            groupIdList = currentContact.groupIdList + selectedGroups.map { it.groupId }
//        )
//        val updatedGroups = selectedGroups.map { it.copy(contactIdList = it.contactIdList + currentContact.contactId)}
//        myViewModel.updateContact(updatedContact)
//        myViewModel.updateGroups(updatedGroups)
//        Toast.makeText(requireContext(), "Contact added to groups", Toast.LENGTH_SHORT).show()
//    }
}
