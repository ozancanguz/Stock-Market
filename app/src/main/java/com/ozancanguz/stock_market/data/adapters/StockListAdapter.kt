package com.ozancanguz.stock_market.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.data.model.stock.Result
import com.ozancanguz.stock_market.data.model.stock.Stock
import kotlinx.android.synthetic.main.stock_row_layout.view.*

class StockListAdapter:RecyclerView.Adapter<StockListAdapter.StockViewHolder>() {

    var stockList= emptyList<Result>()

    fun setData(newData: Stock){
        this.stockList=newData.result
    }

    class StockViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.stock_row_layout,parent,false)
        return StockViewHolder(view)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val currentStock=stockList[position]
        holder.itemView.stock_text.text=currentStock.text
        holder.itemView.stock_last_price.text="Last Price: " +currentStock.lastpricestr
    }

    override fun getItemCount(): Int {
        return stockList.size
    }


}