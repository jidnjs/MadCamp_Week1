package com.example.refactor.ui.adapters

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.refactor.databinding.ItemImageBinding
import com.example.refactor.R
import com.example.refactor.data.entities.Contact
import com.example.refactor.data.entities.Group
import com.example.refactor.data.entities.Image
import com.example.refactor.ui.MyViewModel
import com.example.refactor.ui.contact.SelectGroupsDialogFragment
import com.example.refactor.ui.gallery.ImageInfoDialogFragment
import java.util.Date

class GalleryAlbumAdapter(
    private val myViewModel: MyViewModel,
    private val lifecycleOwner: LifecycleOwner,
    private val fragmentManager: androidx.fragment.app.FragmentManager
) : ListAdapter<Image, GalleryAlbumAdapter.ImageViewHolder>(ImageDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image: Image = getItem(position)
        holder.bind(image)
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Image) {
            Glide.with(binding.imageView.context).load(image.imageUri).into(binding.imageView)
//            binding.imageView
//            binding..text = contact.contactName
//            binding.contactPhoneTextView.text = contact.contactPhoneNumber.toString()
            binding.imageView.setOnClickListener{
                val bundle = Bundle().apply {
                    putLong("imageId", image.imageId)
                }
                val dialog = ImageInfoDialogFragment()
                dialog.arguments = bundle
                dialog.show(fragmentManager, "ImageInfoDialogFragment")
            }
//            binding.root.setOnClickListener {
//                val bundle = Bundle().apply {
//                    putLong("contactId", contact.contactId)
//                }
//                it.findNavController().navigate(R.id.action_contactFragment_to_contactDetailFragment, bundle)
            }
        }
}


class ImageDiffCallback : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.imageId == newItem.imageId
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }
}
