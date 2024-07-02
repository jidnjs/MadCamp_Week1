package com.example.refactor.ui.contact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.refactor.data.entities.Contact
import com.example.refactor.databinding.FragmentContactDetailBinding
import com.example.refactor.ui.MyViewModel

class ContactDetailFragment : Fragment() {

    private lateinit var binding: FragmentContactDetailBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var currentContact: Contact
    private var selectedGroups: List<Long> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        val contactId = arguments?.getLong("contactId") ?: return

        myViewModel.getContactByContactId(contactId).observe(viewLifecycleOwner) { contact ->
            if (contact != null) {
                currentContact = contact
                bindContactDetails(contact)
            }
        }

        requireActivity().supportFragmentManager.setFragmentResultListener(SelectGroupsDialogFragment.REQUEST_KEY, viewLifecycleOwner) { key, bundle ->
            selectedGroups = bundle.getLongArray(SelectGroupsDialogFragment.BUNDLE_KEY)?.toList() ?: emptyList()
            Log.d("ContactDetailFrag", "selectedGroupIdList: $selectedGroups")
        }

        binding.groupSelection.setOnClickListener {
            val bundle = Bundle().apply {
                putLong("contactId", currentContact.contactId)
            }
            val dialog = SelectGroupsDialogFragment()
            dialog.arguments = bundle
            dialog.show(childFragmentManager, "SelectGroupsDialogFragment")
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
                groupIdList = selectedGroups // Update with selected groups
            )
            myViewModel.updateContact(updatedContact)
            updateGroupsWithContact()
        }
    }

    private fun updateGroupsWithContact() {
        myViewModel.updateGroupsWithContactId(currentContact.contactId, currentContact.groupIdList, selectedGroups)
        Toast.makeText(requireContext(), "Contact and groups updated", Toast.LENGTH_SHORT).show()
    }
}
