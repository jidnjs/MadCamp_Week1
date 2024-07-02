package com.example.madcamp_week1.ui.gallery

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import com.example.madcamp_week1.R
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.adapter.ImageAdapter
import java.io.IOException
import android.app.Activity
import android.content.ContentUris
import android.provider.DocumentsContract
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    private val images = mutableListOf<String>()

    //SAF file picker launcher
    private val selectImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                val imagePath = getPathFromUri(uri)  // Get the path from URI
                imagePath?.let {
                    images.add(it)
                    imageAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)

        //val images = loadImagesFromAssets()
        imageAdapter = ImageAdapter(requireContext(), images)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2) // 3 columns in the grid
        recyclerView.adapter = imageAdapter

        val fab: FloatingActionButton = root.findViewById(R.id.fab)
        fab.setOnClickListener {
            openImagePicker()
        }

        // Load images from both gallery and assets
        //images.addAll(loadImagesFromGallery())
        images.addAll(loadImagesFromAssets())
        Log.d("GalleryFragment", "Loaded images: ${images.size}") // Logging loaded images
        imageAdapter.notifyDataSetChanged()

//        images.addAll(loadImagesFromAssets()) // Load initial images from the gallery
//        Log.d("GalleryFragment", "Loaded images from gallery: ${images.size}") // Logging loaded images
//        imageAdapter.notifyDataSetChanged() //changed
//
//        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        recyclerView.adapter = imageAdapter
//
//        images.addAll(loadImagesFromGallery()) // Corrected
//        images.addAll(loadImagesFromAssets())  // Corrected
//        imageAdapter.notifyDataSetChanged()


        return root
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
        }
        selectImageLauncher.launch(intent)
    }

    //갤러리에서 불러오기
    private fun loadImagesFromGallery(): List<String> {
        val uriList = mutableListOf<String>()
        val uriExternal: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA)

        val sortOrder = "${MediaStore.Images.Media.DATE_ADDED} DESC "

        val cursor: Cursor? = requireContext().contentResolver.query(
            uriExternal,
            projection,
            null,
            null,
            sortOrder
        )

        cursor?.use {
            val columnIndexData = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            while (cursor.moveToNext()) {
                val imagePath = cursor.getString(columnIndexData)
                uriList.add(imagePath)
                Log.d("GalleryFragment", "Gallery image path: $imagePath")
            }
        }
        return uriList
//        Log.i(tag, "Uri: $uriList")   // 1
//        dumpImageMetaData(uri)    // 2
//        showImage(uri)    // 3
    }


    // Load images from assets
    private fun loadImagesFromAssets(): List<String> {
        val assetManager = requireContext().assets
        return try {
            assetManager.list("")?.filter { it.endsWith(".jpg") || it.endsWith(".png") }?.map {

                "file:///android_asset/$it" // Prefix asset paths

            } ?: emptyList()

        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }

    // Function to get path from URI
    private fun getPathFromUri(uri: Uri): String? {
        if (DocumentsContract.isDocumentUri(requireContext(), uri)) {
            if (uri.authority == "com.android.providers.media.documents") {
                val docId = DocumentsContract.getDocumentId(uri)
                val id = docId.split(":")[1]
                val contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                val selection = "_id=?"
                val selectionArgs = arrayOf(id)
                return getDataColumn(contentUri, selection, selectionArgs)
            } else if (uri.authority == "com.android.providers.downloads.documents") {
                val id = DocumentsContract.getDocumentId(uri)
                val contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), id.toLong())
                return getDataColumn(contentUri, null, null)
            }
        } else if (uri.scheme.equals("content", true)) {
            return getDataColumn(uri, null, null)
        } else if (uri.scheme.equals("file", true)) {
            return uri.path
        }
        return null
    }
    // Function to get data column from URI
    private fun getDataColumn(uri: Uri, selection: String?, selectionArgs: Array<String>?): String? {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = requireContext().contentResolver.query(uri, projection, selection, selectionArgs, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val columnIndex = it.getColumnIndexOrThrow(projection[0])
                return it.getString(columnIndex)
            }
        }
        return null
    }
}

//    val READ_REQUEST_CODE: Int = 42
//
//    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {    // 1
//        addCategory(Intent.CATEGORY_OPENABLE)   // 2
//        type = "image/*"    // 3
//    }

//    startActivityForResult(intent, READ_REQUEST_CODE)   // 4
