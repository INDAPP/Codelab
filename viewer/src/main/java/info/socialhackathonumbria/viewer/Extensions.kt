package info.socialhackathonumbria.viewer

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 13/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

fun ImageView.setImageURL(url: String?, callback: ((Exception?) -> Unit)? = null ) {
    Picasso.get()
            .load(url)
            .into(this, object : Callback {
                override fun onSuccess() {
                    callback?.invoke(null)
                }

                override fun onError(e: Exception?) {
                    callback?.invoke(e)
                }

            })
}