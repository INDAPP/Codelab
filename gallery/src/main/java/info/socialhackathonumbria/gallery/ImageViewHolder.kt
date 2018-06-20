package info.socialhackathonumbria.gallery

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.viewholder_image.view.*

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 20/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.imageView
    val progressBar: ProgressBar = itemView.progressBar
}