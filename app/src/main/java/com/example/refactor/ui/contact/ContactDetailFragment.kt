package com.example.refactor.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.refactor.data.entities.Contact
import com.example.refactor.databinding.FragmentContactDetailBinding
import com.example.refactor.ui.MyViewModel

class ContactDetailFragment : Fragment() {

    private lateinit var binding: FragmentContactDetailBinding
    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactDetailBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true) // This enables the back button in the toolbar
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val contactId = arguments?.getLong("contactId") ?: return

        myViewModel.getContactByContactId(contactId).observe(viewLifecycleOwner, Observer { contact ->
            if (contact != null) {
                bindContactDetails(contact)
            }
        })

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
                contactId = arguments?.getLong("contactId") ?: 0L,
                contactName = contactName,
                contactPhoneNumber = contactPhone
                // Update other contact details if needed
            )
            myViewModel.updateContact(updatedContact)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                findNavController().popBackStack() // Navigate back when the back button is pressed
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
