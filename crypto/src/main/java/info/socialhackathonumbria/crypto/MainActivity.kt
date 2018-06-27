package info.socialhackathonumbria.crypto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<CryptoResponse> {
    private val adapter = CryptoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        updateCrypto()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_reload) {
            updateCrypto()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun updateCrypto() {
        Client.service.prices("BTC,ETH,LTC,XRP,BCH,XMR", "USD,EUR,GBP")
                .enqueue(this)
    }

    override fun onResponse(call: Call<CryptoResponse>?, response: Response<CryptoResponse>?) {
        val cryptoResponse = response?.body() ?: return
        adapter.cryptos = mapOf(
                "BTC" to cryptoResponse.BTC,
                "ETH" to cryptoResponse.ETH,
                "LTC" to cryptoResponse.LTC,
                "XRP" to cryptoResponse.XRP,
                "BCH" to cryptoResponse.BCH,
                "XMR" to cryptoResponse.XMR
        )
    }

    override fun onFailure(call: Call<CryptoResponse>?, t: Throwable?) {
        t?.printStackTrace()
    }


}
