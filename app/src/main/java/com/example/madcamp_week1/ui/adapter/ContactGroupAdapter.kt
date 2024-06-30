package com.example.madcamp_week1.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import com.example.madcamp_week1.repository.Repository
import com.example.madcamp_week1.repository.model.Group
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactGroupAdapter(
    private val groups: List<Group>,
    private val repository: Repository,
    private val scope: CoroutineScope
) : RecyclerView.Adapter<ContactGroupAdapter.ContactGroupViewHolder>() {

    private var expandedPosition = -1

    inner class ContactGroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val groupName: TextView = view.findViewById(R.id.groupName)
        val contactRecyclerView: RecyclerView = view.findViewById(R.id.contactRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactGroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_group_item, parent, false)
        return ContactGroupViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactGroupViewHolder, position: Int) {
        val group = groups[position]
        holder.groupName.text = group.groupName
        holder.contactRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)

        // Determine if this item should be expanded or collapsed based on its position
        val isExpanded = position == expandedPosition

        // Set the visibility of the RecyclerView based on its expanded state
        holder.contactRecyclerView.visibility = if (isExpanded) View.VISIBLE else View.GONE

        // Set the adapter for the RecyclerView only if it's expanded and the adapter is not set yet
        if (isExpanded) {
            if (holder.contactRecyclerView.adapter == null) {
                scope.launch {
                    val contactList = withContext(Dispatchers.IO) {
                        repository.getContactListByContactIdList(group.contactIdList)
                    }
                    holder.contactRecyclerView.adapter = ContactAdapter(contactList)
                }
            }
        } else {
            holder.contactRecyclerView.adapter = null  // Clear adapter when collapsed
        }

        // Handle item click to expand or collapse the item
        holder.itemView.setOnClickListener {
            val previousExpandedPosition = expandedPosition

            if(isExpanded) expandedPosition = -1
            else expandedPosition = position

            if(previousExpandedPosition != -1) notifyItemChanged(previousExpandedPosition)
            notifyItemChanged(position)
        }
    }
    override fun getItemCount() = groups.size

}

