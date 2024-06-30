package com.example.refactor.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.refactor.R
import com.example.refactor.repository.Contact
import com.example.refactor.repository.Group

class GroupAdapter(
    private val groups: List<Group>,
    private val contacts: List<Contact>
) : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {

    private var expandedGroupId: Long = -1

    class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.contact_group_text_view)
        val recyclerView: RecyclerView = itemView.findViewById(R.id.contact_group_recycler_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact_group, parent, false)
        return GroupViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val group = groups[position]
        holder.textView.text = group.groupName

        val groupContacts = group.contactIdList.mapNotNull { contactId ->
            contacts.find { it.contactId == contactId }
        }

        holder.recyclerView.layoutManager = LinearLayoutManager(holder.recyclerView.context)
        holder.recyclerView.adapter = ContactAdapter(groupContacts)

        holder.recyclerView.visibility = if(group.contactIsExpanded) View.VISIBLE else View.GONE

        holder.textView.setOnClickListener {
            val previouslyExpandedGroupId = expandedGroupId
            if (previouslyExpandedGroupId != -1L) {
                val previousGroup = groups.find { it.groupId == previouslyExpandedGroupId }
                previousGroup?.contactIsExpanded = false
                notifyItemChanged(groups.indexOf(previousGroup))
            }

            if (previouslyExpandedGroupId != group.groupId) {
                group.contactIsExpanded = true
                notifyItemChanged(position)
                expandedGroupId = group.groupId
            } else {
                expandedGroupId = -1
            }
        }
    }

    override fun getItemCount(): Int = groups.size
}