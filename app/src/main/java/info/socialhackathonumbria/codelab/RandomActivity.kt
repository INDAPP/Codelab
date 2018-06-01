package info.socialhackathonumbria.codelab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_random.*
import java.util.*

class RandomActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        val random = Random()

        val max = intent.getIntExtra(EXTRA_COUNTER, 1)
        val rnd = random.nextInt(max)

        val text = getString(R.string.random_description, max)

        textDescription.text = text
        textRandom.text = rnd.toString()
    }


    companion object {
        val EXTRA_COUNTER = "counter"
    }

}
