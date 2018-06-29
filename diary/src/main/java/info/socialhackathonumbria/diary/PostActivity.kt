package info.socialhackathonumbria.diary

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import info.socialhackathonumbria.core.toast
import kotlinx.android.synthetic.main.activity_post.*

const val REQUEST_PHOTO = 1001

class PostActivity : AppCompatActivity() {
    private var bitmap: Bitmap? = null
        set(value) {
            field = value
            imageView.setImageBitmap(value)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        imageView.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_PHOTO)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_post, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.action_save -> {
                savePost()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            REQUEST_PHOTO -> {
                if (resultCode == Activity.RESULT_OK) {
                    this.bitmap = data?.extras?.get("data") as? Bitmap
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun savePost() {
        val bitmap = this.bitmap ?: return toast("Devi scattare una foto")
        val text = editText.text.toString()
        if (text.isBlank()) return toast("Devi scrivere qualcosa")

        //TODO: salvare il post su server
    }

}
