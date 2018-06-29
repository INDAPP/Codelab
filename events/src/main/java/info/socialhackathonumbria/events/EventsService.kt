package info.socialhackathonumbria.events

import retrofit2.Call
import retrofit2.http.GET

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 29/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
interface EventsService {
    @GET("410faa97-546b-4362-a6d7-f8794d18ed19/resource/8afe729a-0f59-4647-95ee-481577e83bea/download/eventijsonitit.zipeventiitit.json")
    fun fetchEvents() : Call<EventsResponse>
}