package com.ozancanguz.stock_market.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.data.model.crpto.Crypto
import com.ozancanguz.stock_market.data.model.crpto.Result
import com.ozancanguz.stock_market.ui.fragments.crypto.CryptoFragmentDirections
import kotlinx.android.synthetic.main.crypto_row_layout.view.*

class CryptoAdapter:RecyclerView.Adapter<CryptoAdapter.CrytoViewHolder>() {

    var cryptoList= emptyList<Result>()

    fun setData(newData: Crypto){
        this.cryptoList=newData.result
        notifyDataSetChanged()
    }
    class CrytoViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrytoViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.crypto_row_layout,parent,false)
        return CrytoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CrytoViewHolder, position: Int) {
        val currentCrypto=cryptoList[position]
        holder.itemView.crypto_img.setImageResource(R.drawable.cryptoimg)
        holder.itemView.crypto_name.text=currentCrypto.name
        holder.itemView.crypto_price.text="Current Price:" +currentCrypto.pricestr+ " USD"

        holder.itemView.setOnClickListener {
            val direction=CryptoFragmentDirections.actionCryptoFragmentToCryptoDetails(currentCrypto)
            holder.itemView.findNavController().navigate(direction)
        }

    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }


}