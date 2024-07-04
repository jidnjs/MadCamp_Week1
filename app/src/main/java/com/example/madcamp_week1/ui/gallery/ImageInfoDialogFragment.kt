package com.example.madcamp_week1.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.madcamp_week1.data.entities.Group
import com.example.madcamp_week1.data.entities.Image
import com.example.madcamp_week1.databinding.FragmentImageInfoBinding
import com.example.madcamp_week1.ui.MyViewModel

class ImageInfoDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentImageInfoBinding
    private lateinit var myViewModel: MyViewModel
    private var currImage: Image? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        val imageId = arguments?.getLong("imageId") ?: 0L

        myViewModel.getImageByImageId(imageId).observe(viewLifecycleOwner, Observer{ image ->
            currImage = image
            currImage?.apply{
                Glide.with(binding.imageView.context).load(imageUri).into(binding.imageView)
                myViewModel.getGroupByGroupId(groupId).observe(viewLifecycleOwner, Observer{ group ->
                    binding.textViewGroupName.text = group!!.groupName
                })
                binding.textViewLocation.text = loc
                binding.textViewDate.text = date.toString()
                if(favorite) binding.toggleButtonFavorite.text = "Favorite: On"
                else binding.toggleButtonFavorite.text = "Favorite: Off"
            }
        })
    }
}