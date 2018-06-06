package info.socialhackathonumbria.core

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 06/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.toast(messageId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, messageId, duration).show()
}

val Activity.prefs: SharedPreferences
    get() = getPreferences(Context.MODE_PRIVATE)

operator fun <T> SharedPreferences.set(key: String, value: T) {
    when (value) {
        is Int -> edit().putInt(key, value).apply()
        is String -> edit().putString(key, value).apply()
        else -> throw Exception("Unhandled type")
    }
}

operator fun <T> SharedPreferences.get(key: String) : T? = all[key] as? T