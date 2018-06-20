package info.socialhackathonumbria.viewer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import info.socialhackathonumbria.core.shareURL
import info.socialhackathonumbria.core.toast
import info.socialhackathonumbria.images.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ImageFragment.OnImageFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent.apply {
            when(action) {
                Intent.ACTION_SEND_MULTIPLE -> {
                    val uris = getParcelableArrayListExtra<Uri>(Intent.EXTRA_STREAM)
                    val urls = uris.map { it.toString() }
                    viewPager.adapter = ImageAdapter(supportFragmentManager, urls)
                }
            }
        }

    }

    override fun onImageShow(index: Int) {
        toast("Immagine $index")
    }

    override fun onShareImageUrl(url: String?) {
        url?.let {
            shareURL(it, "image/*")
        }
    }

}
