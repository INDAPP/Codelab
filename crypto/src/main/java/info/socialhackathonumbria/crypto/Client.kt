package info.socialhackathonumbria.crypto

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 27/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

object Client {
    val service: CryptoService

    init {
        val moshi = Moshi.Builder().build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(
                        MoshiConverterFactory.create(moshi)
                )
                .baseUrl("https://min-api.cryptocompare.com/")
                .build()

        service = retrofit.create(CryptoService::class.java)
    }

}