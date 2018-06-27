package info.socialhackathonumbria.crypto

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.view_holder_crypto.view.*

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 27/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textName: TextView = itemView.textName
    val textUsd: TextView = itemView.textUsd
    val textEur: TextView = itemView.textEur
    val textGbp: TextView = itemView.textGbp

    fun bind(name: String, prices: Prices) {
        textName.text = name
        textUsd.text = "${prices.USD} $"
        textEur.text = "${prices.EUR} €"
        textGbp.text = "${prices.GBP} £"
    }

}