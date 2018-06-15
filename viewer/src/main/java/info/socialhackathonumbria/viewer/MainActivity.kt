package info.socialhackathonumbria.viewer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ImageFragment.OnImageFragmentListener {
    private val urls: Array<String?> = arrayOf(
            "https://picsum.photos/1080/1920/?image=0",
            "https://picsum.photos/1080/1920/?image=1",
            "https://picsum.photos/1080/1920/?image=2",
            "https://picsum.photos/1080/1920/?image=3",
            "https://picsum.photos/1080/1920/?image=4",
            "https://picsum.photos/1080/1920/?image=5",
            "https://picsum.photos/1080/1920/?image=6"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val fragment = ImageFragment.newInstance(0,
//                "https://picsum.photos/1080/1920/?random")
//
//        supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.container, fragment)
//                .commit()

        viewPager.adapter = ImageAdapter(supportFragmentManager, urls)

    }

    override fun onImageShow(index: Int) {

    }

}
