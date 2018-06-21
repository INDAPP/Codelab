package info.socialhackathonumbria.bitcoin

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 21/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
object Client {
    val service: CoindeskService

    init {
        val moshi = Moshi.Builder().build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(
                        MoshiConverterFactory.create(moshi)
                )
                .baseUrl("https://api.coindesk.com/")
                .build()

        service = retrofit.create(CoindeskService::class.java)
    }

}