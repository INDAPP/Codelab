package info.socialhackathonumbria.events

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 27/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

object Client {
    val service: EventsService

    init {
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(
                        MoshiConverterFactory.create(moshi)
                )
                .baseUrl("http://dati.umbria.it/dataset/")
                .build()

        service = retrofit.create(EventsService::class.java)
    }

}