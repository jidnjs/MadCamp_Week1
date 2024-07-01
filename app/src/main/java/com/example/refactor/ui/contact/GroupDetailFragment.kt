package com.example.refactor.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.refactor.R
import com.example.refactor.databinding.FragmentGroupDetailBinding

class GroupDetailFragment : Fragment() {

    private lateinit var binding: FragmentGroupDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.gotoContactGroupButton.setOnClickListener {
//            findNavController().navigate(R.id.action_groupDetailFragment_to_contactFragment)
//        }
//
//        binding.gotoImageGroupButton.setOnClickListener {
//            findNavController().navigate(R.id.action_groupDetailFragment_to_galleryFragment)
//        }
//
//        binding.gotoTodoGroupButton.setOnClickListener {
//            findNavController().navigate(R.id.action_groupDetailFragment_to_todoFragment)
//        }
    }
}
