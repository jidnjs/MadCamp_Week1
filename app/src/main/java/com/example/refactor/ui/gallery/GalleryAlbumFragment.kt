package com.example.refactor.ui.gallery

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.PrimaryKey
import com.example.refactor.data.entities.Image
import com.example.refactor.data.entities.Todo
import com.example.refactor.databinding.FragmentGalleryAlbumBinding
import com.example.refactor.databinding.FragmentGalleryBinding
import com.example.refactor.databinding.FragmentTodoBinding
import com.example.refactor.ui.MyViewModel
import com.example.refactor.ui.adapters.GalleryAlbumAdapter
import com.example.refactor.ui.adapters.GroupAdapter
import com.example.refactor.ui.todo.AddTodoDialogFragment
import com.example.todo.ui.adapters.TodoAdapter
import com.prolificinteractive.materialcalendarview.CalendarDay
import java.util.Calendar
import java.util.Date

class GalleryAlbumFragment : Fragment()  {

    private lateinit var binding: FragmentGalleryAlbumBinding
    private lateinit var galleryAlbumAdapter: GalleryAlbumAdapter
    private lateinit var myViewModel: MyViewModel

    private var currGroupId: Long? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        setupRecyclerView()

        currGroupId = arguments?.getLong("groupId") ?: return

        binding.buttonAddImage.setOnClickListener { openGalleryForImages() }
    }
//            binding.calendarView.setOnDateChangedListener(OnDateSelectedListener { _, date, _ ->
//                val calendar = Calendar.getInstance()
//                calendar.set(date.year, date.month - 1, date.day)
//                selectedDate = calendar.time
//            })
//
//            binding.addTodoButton.setOnClickListener {
//                val addTodoDialog = AddTodoDialogFragment.newInstance(selectedDate)
//                addTodoDialog.show(parentFragmentManager, "AddTodoDialogFragment")
//            }
//        }

        private fun setupRecyclerView() {
            galleryAlbumAdapter = GalleryAlbumAdapter(myViewModel, requireActivity(), childFragmentManager)
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = galleryAlbumAdapter
            }
//
//            val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback())
//            itemTouchHelper.attachToRecyclerView(binding.todoFragmentRecyclerView)

            binding.buttonAddImage.setOnClickListener{
                openGalleryForImages()
            }

            myViewModel.allImages.observe(viewLifecycleOwner, Observer { images ->
                galleryAlbumAdapter.submitList(images.filter { it.groupId == currGroupId })
                galleryAlbumAdapter.notifyDataSetChanged()
            })
        }

    private fun openGalleryForImages() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        pickImagesLauncher.launch(intent)
    }

    private val pickImagesLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                data?.let {
                    val imageUris: MutableList<ImageData> = mutableListOf()
                    if (it.clipData != null) {
                        for (i in 0 until it.clipData!!.itemCount) {
                            val uri = it.clipData!!.getItemAt(i).uri
                            val imageData = getImageData(uri)
                            imageData?.let { imageUris.add(it) }
                        }
                    } else if (it.data != null) {
                        val uri = it.data!!
                        val imageData = getImageData(uri)
                        imageData?.let { imageUris.add(it) }
                    }
                    if(currGroupId != null){
                        imageUris.map{
                            var imgDate: Date? = null
                            if(it.date == null){
                                val today = CalendarDay.today()
                                val calendar = Calendar.getInstance()
                                imgDate = calendar.time
                            }else{
                                imgDate = it.date
                            }
                            myViewModel.addImage(Image(
                                imageUri = it.uri,
                                date = imgDate!!,
                                groupId = currGroupId!!))
                        }
                    }
                    galleryAlbumAdapter.notifyDataSetChanged()
                }
            }
        }

    data class ImageData(val uri: Uri, val date: Date?)

    private fun getImageData(uri: Uri): ImageData? {
        val projection = arrayOf(MediaStore.Images.Media.DATE_TAKEN)
        context?.contentResolver?.query(uri, projection, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val dateIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATE_TAKEN)
                val date = if (dateIndex != -1) {
                    val dateTaken = cursor.getLong(dateIndex)
                    Date(dateTaken)
                } else {
                    null
                }
                return ImageData(uri, date)
            }
        }
        return null
    }
}