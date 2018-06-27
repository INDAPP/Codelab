package info.socialhackathonumbria.crypto

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 27/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

//BTC,ETH,LTC,XRP,BCH,XMR
//USD,EUR,GBP

data class CryptoResponse(
        val BTC: Prices,
        val ETH: Prices,
        val LTC: Prices,
        val XRP: Prices,
        val BCH: Prices,
        val XMR: Prices
)

data class Prices(
        val USD: Float,
        val EUR: Float,
        val GBP: Float
)