package info.socialhackathonumbria.diary

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.view_holder_post.view.*

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 04/07/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.imageView
    val textView: TextView = itemView.textView

    fun bind(post: Post) {

        textView.text = post.text
    }

}