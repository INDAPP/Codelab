package info.socialhackathonumbria.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 04/07/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

class PostAdapter(options: FirebaseRecyclerOptions<Post>)
    : FirebaseRecyclerAdapter<Post, PostViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int, model: Post) {
        holder.bind(model)
    }

}

