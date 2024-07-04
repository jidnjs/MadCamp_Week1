package com.example.madcamp_week1.ui.adapters

import android.os.Bundle
import android.util.Log
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
import com.example.madcamp_week1.R
import com.example.madcamp_week1.data.entities.Group
import com.example.madcamp_week1.databinding.ItemContactGroupBinding
import com.example.madcamp_week1.ui.MyViewModel
import com.example.madcamp_week1.ui.decorators.ContactItemDecorator

class GroupAdapter(
    private val myViewModel: MyViewModel,
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<Group, RecyclerView.ViewHolder>(GroupDiffCallback()) {

    private val TYPE_ALL_CONTACTS = 0
    private val TYPE_GROUP = 1

    private val DEFAULT_EXPANSION = -1L
    private val ALL_CONTACTS_ID = -2L

    private var expandedGroupId: Long? = DEFAULT_EXPANSION

    init{
        myViewModel.addedGroupId.observe(lifecycleOwner, Observer { groupId ->
            expandedGroupId = groupId
            Log.d("GroupAdapter", "expanding..: $groupId")
            this.notifyDataSetChanged()
        })
    }

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
                val bundle = Bundle().apply {
                    putLong("groupId", group.groupId)
                    putString("groupName", group.groupName)
                }
                it.findNavController().navigate(R.id.action_contactFragment_to_groupDetailFragment, bundle)
            }
        }
    }

    inner class AllContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val allContactsRecyclerView: RecyclerView = itemView.findViewById(R.id.contact_group_recycler_view)
        private val allContactsTextView: TextView = itemView.findViewById(R.id.contact_group_text_view)

        fun bind() {
            allContactsTextView.text = "All Contacts"
            allContactsTextView.textSize = 22F
            val contactAdapter = ContactAdapter()
            allContactsRecyclerView.apply {
                layoutManager = LinearLayoutManager(itemView.context)
                adapter = contactAdapter
                addItemDecoration(ContactItemDecorator(context))
            }
            val visibility = if (expandedGroupId == ALL_CONTACTS_ID) View.VISIBLE else View.GONE
            allContactsRecyclerView.visibility = visibility

            myViewModel.allContacts.observe(lifecycleOwner, Observer { contacts ->
                contactAdapter.submitList(contacts)
            })

            itemView.setOnClickListener {
                val isExpanded = expandedGroupId == ALL_CONTACTS_ID
                expandedGroupId = if (isExpanded) DEFAULT_EXPANSION else ALL_CONTACTS_ID
                notifyDataSetChanged()
            }
        }
    }

    private fun toggleGroupExpansion(group: Group) {
        if (isExpanded(group)) {
            expandedGroupId = DEFAULT_EXPANSION
        } else {
            expandedGroupId = group.groupId
        }
        notifyDataSetChanged()
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
