package info.socialhackathonumbria.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
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

fun Context.shareURL(urlString: String, type: String? = null) {
    val intent = Intent(Intent.ACTION_SEND)
    val uri = Uri.parse(urlString)
    intent.putExtra(Intent.EXTRA_STREAM, uri)
    intent.type = type
    this.startActivity(intent)
}


fun Context.shareUrls(urlStrings: List<String>, type: String? = null, index: Int = 0) {
    val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
    val uris = ArrayList(urlStrings.map { Uri.parse(it) })
    intent.putExtra(Intent.EXTRA_STREAM, uris)
    intent.putExtra("android.intent.extra.INDEX", index)
    intent.type = type
    startActivity(intent)
}
