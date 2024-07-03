package com.example.refactor.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.refactor.R
import com.example.refactor.data.entities.Contact
import com.example.refactor.data.entities.Group
import com.example.refactor.databinding.ItemAlbumBinding
import com.example.refactor.databinding.ItemContactBinding
import com.example.refactor.ui.MyViewModel

class GalleryAdapter(
    private var groups: List<Group>,
    private val myViewModel: MyViewModel,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<GalleryAdapter.AlbumViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val group = groups[position]
        holder.bind(group)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    fun submitList(newGroups: List<Group>?) {
        groups = newGroups!!
    }

    inner class AlbumViewHolder(private val binding: ItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(group: Group) {
            binding.albumNameTextView.text = group.groupName
            binding.root.setOnClickListener {
                val bundle = Bundle().apply {
                    putLong("groupId", group.groupId)
                }
                it.findNavController().navigate(R.id.action_galleryFragment_to_galleryAlbumFragment, bundle)
            }
        }
    }
}