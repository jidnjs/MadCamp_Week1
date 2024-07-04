package com.example.madcamp_week1.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.madcamp_week1.data.entities.Contact
import com.example.madcamp_week1.databinding.FragmentAddContactBinding
import com.example.madcamp_week1.ui.MyViewModel

class AddContactDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentAddContactBinding
    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            val name = binding.editContactName.text.toString()
            val phone = binding.editContactPhone.text.toString()
            if (name.isNotEmpty() && phone.isNotEmpty() && phone.isDigitsOnly()) {
                val contact = Contact(contactName = name, contactPhoneNumber = phone.toLong())
                myViewModel.addContact(contact)
                dismiss()
            } else {
                Toast.makeText(context, "Please enter valid contact", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }
}
