// ContactViewHolder.kt
package com.example.myapplication.ui.contacts

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Contact
import com.example.myapplication.R

class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvContactName: TextView = itemView.findViewById(R.id.tvContactName)
    private val tvContactPhoneNumber: TextView = itemView.findViewById(R.id.tvContactPhoneNumber)

    fun bind(contact: Contact) {
        tvContactName.text = contact.name
        tvContactPhoneNumber.text = contact.phoneNumber
        // You can bind other views or set click listeners here if needed
    }
}
