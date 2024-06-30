package com.example.madcamp_week1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.FragmentAddContactBinding
import com.example.madcamp_week1.repository.model.Contact
import com.example.madcamp_week1.ui.MainActivity
import com.example.madcamp_week1.viewmodel.SharedViewModel
import com.example.madcamp_week1.viewmodel.SharedViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddContactFragment : Fragment() {

    private var _binding: FragmentAddContactBinding? = null
    private val binding get() = _binding!!
    private val scope = CoroutineScope(Dispatchers.Main)

    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory((activity as MainActivity).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextName: EditText = binding.editTextContactName
        val editTextPhone: EditText = binding.editTextContactPhoneNumber
        val buttonAddContact: Button = binding.buttonAddContact

        buttonAddContact.setOnClickListener {
            val name = editTextName.text.toString()
            val phone = editTextPhone.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty()) {
                val contact = Contact(
                    contactId = 0, // Auto-generated by Room
                    contactName = name,
                    contactPhoneNumber = phone.toInt(),
                    contactEmail = "",
                    contactMemo = "",
                    groupIdList = emptyList()
                )
                scope.launch {
                    sharedViewModel.addContact(contact)
                    // Navigate back to ContactsFragment after adding contact
                    findNavController().navigateUp()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
