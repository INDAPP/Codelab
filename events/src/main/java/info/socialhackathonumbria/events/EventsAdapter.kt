package info.socialhackathonumbria.events

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 29/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

class EventsAdapter : RecyclerView.Adapter<EventViewHolder>() {
    var events: List<Event> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_holder_event, parent, false)
        return EventViewHolder(view)
    }

    override fun getItemCount() = events.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

}