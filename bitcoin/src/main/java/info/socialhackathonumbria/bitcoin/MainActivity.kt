package info.socialhackathonumbria.bitcoin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<CoindeskResponse> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Client.service.fetchLastPrice().enqueue(this)
    }

    override fun onResponse(call: Call<CoindeskResponse>?, response: Response<CoindeskResponse>?) {
        progressBar.visibility = View.GONE

        val body = response?.body()

        if (body != null) {
            textView.text = "1 BTC = ${body.bpi.EUR.rate_float} ${body.bpi.EUR.code}"
        } else {
            textView.text = "Non sono presenti informazioni"
        }
    }

    override fun onFailure(call: Call<CoindeskResponse>?, t: Throwable?) {
        progressBar.visibility = View.GONE

        textView.text = "Si è verificato un errore"
    }
}
