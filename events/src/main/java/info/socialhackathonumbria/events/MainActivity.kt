package info.socialhackathonumbria.events

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import info.socialhackathonumbria.core.toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<EventsResponse> {
    val adapter = EventsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        update()
    }

    fun update() {
        Client.service.fetchEvents().enqueue(this)
    }

    override fun onFailure(call: Call<EventsResponse>?, t: Throwable?) {
        t?.printStackTrace()
        toast("Si è verificato un errore")
    }

    override fun onResponse(call: Call<EventsResponse>?, response: Response<EventsResponse>?) {
        response?.body()?.contenuto?.let {
            adapter.events = it
        }

    }

}
