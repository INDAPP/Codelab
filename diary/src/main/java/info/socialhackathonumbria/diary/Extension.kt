package info.socialhackathonumbria.diary

import android.content.Context
import android.widget.Toast

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 04/07/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
