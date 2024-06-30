//package com.example.madcamp_week1.ui.fragment
//
//import android.content.ContentValues
//import android.database.sqlite.SQLiteDatabase
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.core.text.isDigitsOnly
//import androidx.fragment.app.Fragment
//import com.example.madcamp_week1.local.database.ContactsDatabase
//
//import androidx.navigation.fragment.findNavController
//
//import com.example.madcamp_week1.R
//import com.example.madcamp_week1.local.dao.ContactsDao
//
//
//class AddContactFragment : Fragment() {
//
//    private lateinit var etName: EditText
//    private lateinit var etPhoneNumber: EditText
//    private lateinit var btnSave: Button
//
//    private lateinit var database: SQLiteDatabase
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_add_contact, container, false)
//
//        // Initialize views
//        etName = view.findViewById(R.id.etContactName)
//        etPhoneNumber = view.findViewById(R.id.etContactPhone)
//        btnSave = view.findViewById(R.id.buttonSaveContact)
//
//        // Set click listener for save button
//        btnSave.setOnClickListener {
//            saveContact()
//            findNavController().navigateUp()
//        }
//
//        // Initialize database
//        database = ContactsDatabase(requireContext()).writableDatabase
//
//        return view
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//    }
//
//    private fun saveContact() {
//        val name = etName.text.toString().trim()
//        val phoneNumber = etPhoneNumber.text.toString().trim()
//
//        if(name.isEmpty())
//            Toast.makeText(this.context, "Please enter name", Toast.LENGTH_LONG).show()
//        else if(phoneNumber.isEmpty())
//            Toast.makeText(this.context, "Please enter phone number", Toast.LENGTH_LONG).show()
//        else if(phoneNumber.isDigitsOnly().not())
//            Toast.makeText(this.context, "Please enter digits only", Toast.LENGTH_LONG).show()
//        else{
//            ContactsDao.AddContact
//        }
//        if (name.isNotEmpty() && phoneNumber.isNotEmpty()) {
//            // Insert new contact into database
//            val contentValues = ContentValues().apply {
//                put(ContactsDatabase.KEY_NAME, name)
//                put(ContactsDatabase.KEY_PHONE_NUMBER, phoneNumber)
//            }
//            val newRowId = database.insert(ContactsDatabase.TABLE_CONTACTS, null, contentValues)
//
//            // Optionally, notify parent fragment or activity about the contact being added
//            // For example, you might notify ContactFragment to refresh the RecyclerView
//
//            // Clear input fields or perform other UI updates
//            etName.setText("")
//            etPhoneNumber.setText("")
//        } else {
//            // Handle case where fields are empty
//            // Optionally, show an error message or toast
//        }
//    }
//}
