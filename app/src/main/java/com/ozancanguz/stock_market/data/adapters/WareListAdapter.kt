package com.ozancanguz.stock_market.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.data.model.ware.Result
import com.ozancanguz.stock_market.data.model.ware.Ware
import com.ozancanguz.stock_market.ui.fragments.ware.WareFragment
import com.ozancanguz.stock_market.ui.fragments.ware.WareFragmentDirections
import kotlinx.android.synthetic.main.ware_row_layout.view.*

class WareListAdapter:RecyclerView.Adapter<WareListAdapter.WareViewHolder>() {

      var wareList= emptyList<Result>()

      fun setData(newData: Ware){
          this.wareList=newData.result
          notifyDataSetChanged()
      }

    class WareViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WareViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.ware_row_layout,parent,false)
        return WareViewHolder(view)
    }

    override fun onBindViewHolder(holder: WareViewHolder, position: Int) {
        val currentWare=wareList[position]
        holder.itemView.ware_name.text=currentWare.name
        holder.itemView.ware_text.text=currentWare.text

        holder.itemView.setOnClickListener {
            val action=WareFragmentDirections.actionWareFragmentToWareDetails(currentWare)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return wareList.size
    }


}