package com.example.madcamp_week1.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import java.io.IOException

class ImageAdapter(private val context: Context, private val images: List<String>) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagePath = images[position]
        Log.d("ImageAdapter", "loading image:: $imagePath")
        if (imagePath.startsWith("file:///android_asset/")) {
            Log.d("ImageAdapter", "loading asset:: $imagePath")
            // Load from assets
            try {
                context.assets.open(imagePath.removePrefix("file:///android_asset/")).use { inputStream ->
                    val drawable = Drawable.createFromStream(inputStream, null)
                    holder.imageView.setImageDrawable(drawable)
                    Log.d("ImageAdapter", "load success: $imagePath")
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            // Load from file system
            val imageUri = Uri.parse(imagePath)
            try {
                context.contentResolver.openInputStream(imageUri)?.use { inputStream ->
                    val drawable = Drawable.createFromStream(inputStream, null)
                    holder.imageView.setImageDrawable(drawable)
                }
            } catch (e: IOException) {
//                e.printStackTrace()
            }
        }
    }
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val imagePath = images[position]
//        try {
//            context.assets.open(imagePath).use { inputStream ->
//                val drawable = Drawable.createFromStream(inputStream, null)
//                holder.imageView.setImageDrawable(drawable)
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }

    override fun getItemCount(): Int = images.size
}
