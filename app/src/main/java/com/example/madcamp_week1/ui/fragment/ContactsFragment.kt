package com.example.madcamp_week1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.FragmentContactsBinding
import com.example.madcamp_week1.ui.MainActivity
import com.example.madcamp_week1.ui.adapter.ContactGroupAdapter
import com.example.madcamp_week1.viewmodel.SharedViewModel
import com.example.madcamp_week1.viewmodel.SharedViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    private lateinit var contactFragRecyclerView: RecyclerView
    private val scope = CoroutineScope(Dispatchers.Main)

    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory((activity as MainActivity).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactFragRecyclerView = view.findViewById(R.id.contactFragRecyclerView)
        contactFragRecyclerView.layoutManager = LinearLayoutManager(context)

        loadGroups()
    }

    private fun loadGroups() {
        scope.launch {
            val groups = withContext(Dispatchers.IO) {
                sharedViewModel.repository.getAllGroups()
            }
            contactFragRecyclerView.adapter = ContactGroupAdapter(groups, sharedViewModel.repository, scope)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
