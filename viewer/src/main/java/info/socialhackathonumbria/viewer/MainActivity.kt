package info.socialhackathonumbria.viewer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import info.socialhackathonumbria.core.shareURL
import info.socialhackathonumbria.core.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ImageFragment.OnImageFragmentListener {
    val urls: Array<String?> = (0..6).map(this::getUrl).toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ImageAdapter(supportFragmentManager, urls)

    }

    fun getUrl(index: Int) = "https://picsum.photos/1080/1920/?image=$index"

    override fun onImageShow(index: Int) {
        toast("Immagine $index")
    }

    override fun onShareImageUrl(url: String?) {
        url?.let {
            shareURL(it, "image/*")
        }
    }

}
