// ContactAdapter.kt
package com.example.myapplication.ui.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Contact

class ContactAdapter(
    private val context: Context,
    private val contactList: List<Contact>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ContactsViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(contact: Contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ContactsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contact = contactList[position]
        holder.bind(contact)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(contact)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}
