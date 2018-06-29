package info.socialhackathonumbria.events

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import info.socialhackathonumbria.images.setImageURL
import kotlinx.android.synthetic.main.view_holder_event.view.*

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 29/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.imageView
    val textTitle: TextView = itemView.textTitle
    val textDescription: TextView = itemView.textDescription

    fun bind(event: Event) {
        textTitle.text = event.titolo
        textDescription.text = event.descrizione
        imageView.setImageURL(event.immagine)
    }

}