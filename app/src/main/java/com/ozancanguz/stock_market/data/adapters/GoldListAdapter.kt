package com.ozancanguz.stock_market.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.data.model.gold.Gold
import com.ozancanguz.stock_market.data.model.gold.Result
import kotlinx.android.synthetic.main.goldlist_row_layout.view.*

class GoldListAdapter:RecyclerView.Adapter<GoldListAdapter.GoldViewHolder>() {

    class GoldViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    var goldPriceList= emptyList<Result>()

    fun setData(newData: Gold){
          this.goldPriceList=newData.result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoldViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.goldlist_row_layout,parent,false)
        return GoldViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoldViewHolder, position: Int) {
       val currentGold=goldPriceList[position]
        holder.itemView.gold_name.text=currentGold.name
        holder.itemView.gold_img.setImageResource(R.drawable.gold)
    }

    override fun getItemCount(): Int {
        return goldPriceList.size
    }


}