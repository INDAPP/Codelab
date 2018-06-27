package info.socialhackathonumbria.crypto

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 27/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
interface CryptoService {

    //https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR
    @GET("data/pricemulti")
    fun prices(
            @Query("fsyms") cryptos: String,
            @Query("tsyms") currencies: String
    ) : Call<CryptoResponse>

}