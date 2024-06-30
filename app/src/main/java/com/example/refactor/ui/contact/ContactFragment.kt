package com.example.refactor.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.refactor.R
import com.example.refactor.databinding.FragmentContactBinding
import com.example.refactor.repository.Contact
import com.example.refactor.repository.Group
import com.example.refactor.viewmodel.GroupAdapter

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val groupList: List<Group> = getGroups()
    private val contactList: List<Contact> = getContacts()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.contact_fragment_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = GroupAdapter(groupList, contactList)
    }

    private fun getGroups(): List<Group> {
        // Sample data
        return listOf(
            Group(1, "Group 1", listOf(1, 2)),
            Group(2, "Group 2", listOf(3, 4))
        )
    }

    private fun getContacts(): List<Contact> {
        // Sample data
        return listOf(
            Contact(1, "Contact 1", 1234567890),
            Contact(2, "Contact 2", 2345678901),
            Contact(3, "Contact 3", 3456789012),
            Contact(4, "Contact 4", 4567890123)
        )
    }
}