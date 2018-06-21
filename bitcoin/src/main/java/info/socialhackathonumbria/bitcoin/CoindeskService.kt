package info.socialhackathonumbria.bitcoin

import retrofit2.Call
import retrofit2.http.GET

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 21/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
interface CoindeskService {

    @GET("v1/bpi/currentprice.json")
    fun fetchLastPrice() : Call<CoindeskResponse>

}