package com.example.madcamp_week1.ui.contact

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madcamp_week1.R
import com.example.madcamp_week1.data.AppDatabase
import com.example.madcamp_week1.data.entities.Group
import com.example.madcamp_week1.databinding.FragmentContactBinding
import com.example.madcamp_week1.ui.MyViewModel
import com.example.madcamp_week1.ui.adapters.GroupAdapter

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding
    private lateinit var groupAdapter: GroupAdapter
    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        setupRecyclerView()

        binding.btnAddGroup.setOnClickListener {
            AddGroupDialogFragment().show(parentFragmentManager, "AddGroupDialog")
        }

        binding.btnAddContact.setOnClickListener {
            AddContactDialogFragment().show(parentFragmentManager, "AddContactDialog")
        }
    }

    override fun onResume() {
        super.onResume()
        // Scroll to top when the fragment becomes visible
        binding.contactFragmentRecyclerView.layoutManager?.scrollToPosition(0)
    }

    private fun setupRecyclerView() {
        groupAdapter = GroupAdapter(myViewModel, requireActivity())
        binding.contactFragmentRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }

        myViewModel.allGroups.observe(viewLifecycleOwner, Observer {
            Handler(Looper.getMainLooper()).postDelayed({
                myViewModel.allGroups.observe(viewLifecycleOwner, Observer{ groups ->
                    groupAdapter.submitList(groups)
                    groupAdapter.notifyDataSetChanged()
                })
            }, 20) // 300 milliseconds delay
        })
    }
}
