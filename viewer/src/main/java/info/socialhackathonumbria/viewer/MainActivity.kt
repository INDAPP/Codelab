package info.socialhackathonumbria.viewer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setImageURL("https://picsum.photos/1080/1920/?random") {
            progressBar.visibility = View.GONE
        }

//        Picasso.get()
//                .load("https://picsum.photos/1080/1920/?random")
//                .into(imageView, object : Callback {
//
//                    override fun onSuccess() {
//                        progressBar.visibility = View.GONE
//                    }
//
//                    override fun onError(e: Exception?) {
//                        progressBar.visibility = View.GONE
//                    }
//
//                })
    }
}
