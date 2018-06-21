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

        response?.body()?.let {
            textView.text = "1 BTC = ${it.bpi.EUR.rate_float} ${it.bpi.EUR.code}"
        }
    }

    override fun onFailure(call: Call<CoindeskResponse>?, t: Throwable?) {
        progressBar.visibility = View.GONE

        textView.text = "Si è verificato un errore"
    }
}
