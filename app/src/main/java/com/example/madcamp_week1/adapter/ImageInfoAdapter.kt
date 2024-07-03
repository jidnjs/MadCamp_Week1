// ImageInfoAdapter.kt
package com.example.madcamp_week1.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_week1.R
import com.example.madcamp_week1.model.Image

class ImageInfoAdapter(private val imageInfoList: List<Image>) :
    RecyclerView.Adapter<ImageInfoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = imageInfoList[position]
        holder.textView.text = """
            Image ID: ${image.imageId}
            URL: ${image.imageURL}
            Favorite: ${image.favorite}
            Tag: ${image.imageTag}
            Date: ${image.date}
            DateTime: ${image.dateTime}
            Location: ${image.loc}
        """.trimIndent()
    }

    override fun getItemCount() = imageInfoList.size
}
