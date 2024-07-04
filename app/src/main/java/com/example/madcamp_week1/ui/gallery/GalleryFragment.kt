package com.example.madcamp_week1.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.madcamp_week1.databinding.FragmentGalleryBinding
import com.example.madcamp_week1.ui.MyViewModel
import com.example.madcamp_week1.ui.adapters.GalleryAdapter
import com.example.madcamp_week1.ui.adapters.GroupAdapter

class GalleryFragment : Fragment() {
    private lateinit var binding: FragmentGalleryBinding
    private lateinit var galleryAdapter: GalleryAdapter
    private lateinit var groupAdapter: GroupAdapter
    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        galleryAdapter = GalleryAdapter(emptyList(), myViewModel, requireActivity())
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = galleryAdapter
        }

        myViewModel.allGroups.observe(viewLifecycleOwner, Observer { groups ->
            galleryAdapter.submitList(groups)
            galleryAdapter.notifyDataSetChanged()
        })


//
//        myViewModel.allGroups.observe(viewLifecycleOwner, Observer {
//            Handler(Looper.getMainLooper()).postDelayed({
//                myViewModel.allGroups.observe(viewLifecycleOwner, Observer{ groups ->
//                    groupAdapter.submitList(groups)
//                    groupAdapter.notifyDataSetChanged()
//                })
//            }, 20) // 300 milliseconds delay
//        })
    }
}