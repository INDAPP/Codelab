package info.socialhackathonumbria.codelab

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import info.socialhackathonumbria.core.get
import info.socialhackathonumbria.core.prefs
import info.socialhackathonumbria.core.set
import info.socialhackathonumbria.core.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var anim: Animation

    var count = 0
        set(value) {
            field = value
            textView.text = value.toString()
            textView.startAnimation(anim)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        anim = AnimationUtils.loadAnimation(this, R.anim.pulse)

        buttonToast.setOnClickListener(this::showToast)
        buttonCount.setOnClickListener(this::increaseCount)
        buttonRandom.setOnClickListener(this::showRandom)
    }

    override fun onResume() {
        super.onResume()
//        val prefs = getPreferences(Context.MODE_PRIVATE)
//        count = prefs.getInt("counter", 0)
        count = prefs["counter"] ?: 0
    }

    override fun onPause() {
//        val prefs = getPreferences(Context.MODE_PRIVATE)
//        val editor = prefs.edit()
//        editor.putInt("counter", count)
//        editor.apply()
        prefs["counter"] = count

        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_reset -> resetCounter()
        else -> super.onOptionsItemSelected(item)
    }

    fun resetCounter() : Boolean {
        AlertDialog.Builder(this)
                .setTitle("Attenzione")
                .setMessage("Vuoi azzerare il contatore?")
                .setNegativeButton("Annulla", null)
                .setPositiveButton("Ok", this::resetConfirm)
                .show()

        return true
    }

    fun resetConfirm(dialog: DialogInterface, wich: Int) {
        count = 0
    }


    fun showToast(view: View) {
//        val toast = Toast.makeText(this, "Questo è un toast", Toast.LENGTH_SHORT)
//        toast.show()
        toast(R.string.toast_message)
    }

    fun increaseCount(view: View) {
        count++
    }

    fun showRandom(view: View) {
        val intent = Intent(this, RandomActivity::class.java)

        intent.putExtra(RandomActivity.EXTRA_COUNTER, count)

        startActivity(intent)
    }

}
