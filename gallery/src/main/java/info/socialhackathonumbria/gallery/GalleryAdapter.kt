package info.socialhackathonumbria.gallery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.socialhackathonumbria.images.setImageURL

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 20/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
class GalleryAdapter(val urls: List<String>) : RecyclerView.Adapter<ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.viewholder_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int = urls.size


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.progressBar.visibility = View.VISIBLE
        holder.imageView.setImageURL(urls[position]) {
            holder.progressBar.visibility = View.GONE
        }
    }

}