package info.socialhackathonumbria.bitcoin

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 21/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
data class CoindeskResponse(
        val time: Time,
        val disclaimer: String,
        val chartName: String,
        val bpi: Bpi
)

data class Time(
        val updated: String,
        val updatedISO: String,
        val updateduk: String
)

data class Bpi(
        val USD: PriceInfo,
        val GBP: PriceInfo,
        val EUR: PriceInfo
)

data class PriceInfo(
        val code: String,
        val symbol: String,
        val rate: String,
        val description: String,
        val rate_float: Float
)