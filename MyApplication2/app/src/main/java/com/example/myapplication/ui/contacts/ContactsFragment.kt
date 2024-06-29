package com.example.myapplication.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentContactsBinding
import com.example.myapplication.model.Contact
import com.example.myapplication.database.ContactsDatabase
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.ui.contacts.ContactAdapter
import com.example.myapplication.R

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contactList: MutableList<Contact>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize RecyclerView and adapter
        contactList = mutableListOf()
        contactAdapter = ContactAdapter(requireContext(), contactList, object : ContactAdapter.OnItemClickListener {
            override fun onItemClick(contact: Contact) {
                // Handle item click if needed
            }
        })

        binding.recyclerViewContacts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = contactAdapter
        }

        // Load contacts from database
        loadContactsFromDatabase()

        // Navigate to AddContactFragment when button is clicked
        binding.btnAddContact.setOnClickListener {
            findNavController().navigate(R.id.action_contactsFragment_to_addContactFragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadContactsFromDatabase() {
        val database = ContactsDatabase(requireContext())
        val newContacts = database.getAllContacts()

        // Calculate the difference between old and new contact lists
        val diffResult = calculateDiff(contactList, newContacts)

        // Update contactList with new data
        contactList.clear()
        contactList.addAll(newContacts)

        // Apply the calculated diff to the adapter
        diffResult.dispatchUpdatesTo(contactAdapter)
    }

    private fun calculateDiff(oldList: List<Contact>, newList: List<Contact>): DiffUtil.DiffResult {
        return DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return oldList.size
            }

            override fun getNewListSize(): Int {
                return newList.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].id == newList[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldContact = oldList[oldItemPosition]
                val newContact = newList[newItemPosition]
                return oldContact == newContact
            }
        })
    }
}
