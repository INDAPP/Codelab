package info.socialhackathonumbria.crypto

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 27/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

class CryptoAdapter : RecyclerView.Adapter<CryptoViewHolder>() {
    var cryptos: Map<String, Prices> = emptyMap()
        set(value) {
            field = value
            keys = value.keys.toList()
            notifyDataSetChanged()
        }

    private var keys: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_holder_crypto, parent, false)
        return CryptoViewHolder(view)
    }

    override fun getItemCount() = keys.size

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val key = keys[position]
        val prices = cryptos[key]!!
        holder.bind(key.toUpperCase(), prices)
    }

}