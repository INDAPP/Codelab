package info.socialhackathonumbria.gallery

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import info.socialhackathonumbria.core.shareUrls
import info.socialhackathonumbria.images.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GalleryAdapter.OnItemClickListener {
    val urls = Utils.generateImages(120, 300, 300)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = GridLayoutManager(this, 3)
        recyclerView.layoutManager = layoutManager

        val adapter = GalleryAdapter(urls, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val urls = Utils.generateImages(120)
        shareUrls(urls, "image/*", position)
    }
}
