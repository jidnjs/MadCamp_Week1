package com.example.refactor.ui.contact

// Import necessary libraries
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.refactor.R
import com.example.refactor.data.entities.Contact
import com.example.refactor.data.entities.Group
import com.example.refactor.databinding.FragmentContactDetailBinding
import com.example.refactor.ui.MyViewModel

class ContactDetailFragment : Fragment() {

    private lateinit var binding: FragmentContactDetailBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var currentContact: Contact
    private var selectedGroups: List<Group> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val contactId = arguments?.getLong("contactId") ?: return

        myViewModel.getContactByContactId(contactId).observe(viewLifecycleOwner) { contact ->
            if (contact != null) {
                currentContact = contact
                bindContactDetails(contact)
            }
        }

        setFragmentResultListener("requestKey") { key, bundle ->
            @Suppress("UNCHECKED_CAST")
            selectedGroups = bundle.getParcelableArrayList<Group>("selectedGroups") ?: emptyList()
        }

        binding.groupSelection.setOnClickListener {
            val bundle = Bundle().apply {
                putLong("contactId", currentContact.contactId)
            }
            findNavController().navigate(R.id.action_contactDetailFragment_to_groupSelectionFragment, bundle)
        }

        binding.btnSave.setOnClickListener {
            saveContactDetails()
            findNavController().popBackStack() // Navigate back after saving
        }
    }

    private fun bindContactDetails(contact: Contact) {
        binding.editContactName.setText(contact.contactName)
        binding.editContactPhone.setText(contact.contactPhoneNumber.toString())
        // Load other contact details and setup group selection if needed
    }

    private fun saveContactDetails() {
        val contactName = binding.editContactName.text.toString()
        val contactPhone = binding.editContactPhone.text.toString().toLongOrNull()
        if (contactName.isNotEmpty() && contactPhone != null) {
            val updatedContact = Contact(
                contactId = currentContact.contactId,
                contactName = contactName,
                contactPhoneNumber = contactPhone,
                groupIdList = selectedGroups.map { it.groupId } // Update with selected groups
            )
            myViewModel.updateContact(updatedContact)
            updateGroupsWithContact()
        }
    }

    private fun updateGroupsWithContact() {
        val updatedGroups = selectedGroups.map { it.copy(contactIdList = it.contactIdList + currentContact.contactId) }
        myViewModel.updateGroups(updatedGroups)
        Toast.makeText(requireContext(), "Contact and groups updated", Toast.LENGTH_SHORT).show()
    }
}
