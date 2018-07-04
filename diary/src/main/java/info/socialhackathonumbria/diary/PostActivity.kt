package info.socialhackathonumbria.diary

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_post.*
import java.io.ByteArrayOutputStream
import java.util.*

const val REQUEST_PHOTO = 1001

class PostActivity : AppCompatActivity() {
    lateinit var storage: StorageReference
    lateinit var database: DatabaseReference

    private var bitmap: Bitmap? = null
        set(value) {
            field = value
            imageView.setImageBitmap(value)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        storage = FirebaseStorage.getInstance().reference
        database = FirebaseDatabase.getInstance().reference

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

        upload(bitmap) {
            save(text, it)
        }
    }

    fun upload(bitmap: Bitmap, callback: (String) -> Unit) {
        val uuid = UUID.randomUUID().toString()
        val newImageRef = storage.child("$uuid.jpg")
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        val data = stream.toByteArray()
        newImageRef.putBytes(data)
                .addOnFailureListener {
                    it.printStackTrace()
                    toast("Si è verificato un errore durante il caricamento dell'immagine")
                }
                .addOnSuccessListener {
//                    val url = it.uploadSessionUri.toString()
                    callback("$uuid.jpg")
                }
    }

    fun save(text: String, imageName: String) {
        val post = Post(text, imageName)
        database.child("posts").push().setValue(post)
        toast("Nuovo post creato!")
        finish()
    }

}
