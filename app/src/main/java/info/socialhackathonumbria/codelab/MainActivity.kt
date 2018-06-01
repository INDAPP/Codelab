package info.socialhackathonumbria.codelab

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToast.setOnClickListener(this::showToast)
        buttonCount.setOnClickListener(this::increaseCount)
        buttonRandom.setOnClickListener(this::showRandom)
    }


    fun showToast(view: View) {
        val toast = Toast.makeText(this, "Questo è un toast", Toast.LENGTH_SHORT)

        toast.show()
    }

    fun increaseCount(view: View) {
        count++
        textView.text = "$count"
    }

    fun showRandom(view: View) {
        val intent = Intent(this, RandomActivity::class.java)

        intent.putExtra(RandomActivity.EXTRA_COUNTER, count)

        startActivity(intent)
    }


}
