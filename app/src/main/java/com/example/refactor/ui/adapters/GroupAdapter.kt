package com.example.refactor.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.example.refactor.R
import com.example.refactor.data.entities.Group
import com.example.refactor.databinding.ItemContactGroupBinding
import com.example.refactor.ui.MyViewModel

class GroupAdapter(
    private val myViewModel: MyViewModel,
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<Group, RecyclerView.ViewHolder>(GroupDiffCallback()) {

    private val TYPE_ALL_CONTACTS = 0
    private val TYPE_GROUP = 1

    private var expandedGroupId: Long? = -1L

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_ALL_CONTACTS else TYPE_GROUP
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ALL_CONTACTS) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact_group, parent, false)
            AllContactsViewHolder(view)
        } else {
            val binding = ItemContactGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            GroupViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == TYPE_ALL_CONTACTS) {
            (holder as AllContactsViewHolder).bind()
        } else {
            val group = getItem(position - 1) // Adjust for "All Contacts" item
            (holder as GroupViewHolder).bind(group)
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 1 // Adding one for "All Contacts"
    }

    private fun isExpanded(group: Group): Boolean {
        return expandedGroupId == group.groupId
    }

    inner class GroupViewHolder(private val binding: ItemContactGroupBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(group: Group) {
            binding.contactGroupTextView.text = group.groupName
            val visibility: Int = if (isExpanded(group)) View.VISIBLE else View.GONE
            binding.contactGroupRecyclerView.visibility = visibility
            binding.groupDetails.visibility = visibility
            // Set up the nested recycler view for contacts
            val contactAdapter = ContactAdapter()
            binding.contactGroupRecyclerView.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = contactAdapter
            }

            myViewModel.getContactListByContactIdList(group.contactIdList).observe(lifecycleOwner, Observer { contacts ->
                contactAdapter.submitList(contacts)
            })

            binding.root.setOnClickListener {
                toggleGroupExpansion(group)
            }

            binding.groupDetails.setOnClickListener {
                it.findNavController().navigate(R.id.action_contactFragment_to_groupDetailFragment)
            }
        }
    }

    inner class AllContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val allContactsRecyclerView: RecyclerView = itemView.findViewById(R.id.contact_group_recycler_view)
        private val allContactsTextView: TextView = itemView.findViewById(R.id.contact_group_text_view)

        fun bind() {
            allContactsTextView.text = "All Contacts"
            val contactAdapter = ContactAdapter()
            allContactsRecyclerView.apply {
                layoutManager = LinearLayoutManager(itemView.context)
                adapter = contactAdapter
            }
            val visibility = if (expandedGroupId == Group.ALL_CONTACTS_ID) View.VISIBLE else View.GONE
            allContactsRecyclerView.visibility = visibility

            myViewModel.allContacts.observe(lifecycleOwner, Observer { contacts ->
                contactAdapter.submitList(contacts)
            })

            itemView.setOnClickListener {
                toggleAllContactsExpansion()
            }
        }

        private fun toggleAllContactsExpansion() {
            val isExpanded = expandedGroupId == Group.ALL_CONTACTS_ID
            expandedGroupId = if (isExpanded) -1L else Group.ALL_CONTACTS_ID
            notifyDataSetChanged()
        }
    }

    private fun toggleGroupExpansion(group: Group) {
        if (isExpanded(group)) {
            expandedGroupId = -1L
        } else {
            expandedGroupId = group.groupId
            notifyDataSetChanged()
        }
    }
}

class GroupDiffCallback : DiffUtil.ItemCallback<Group>() {
    override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
        return oldItem.groupId == newItem.groupId
    }

    override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
        return oldItem == newItem
    }
}
