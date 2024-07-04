package com.example.madcamp_week1.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.madcamp_week1.data.entities.Group
import com.example.madcamp_week1.databinding.FragmentAddGroupBinding
import com.example.madcamp_week1.ui.MyViewModel

class AddGroupDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentAddGroupBinding
    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddGroupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            val name = binding.editGroupName.text.toString()
            if (name.isNotEmpty()) {
                val group = Group(groupName = name, contactIdList = emptyList())
                myViewModel.addGroup(group)
                dismiss()
            } else {
                Toast.makeText(context, "Please enter a group name", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }
}
