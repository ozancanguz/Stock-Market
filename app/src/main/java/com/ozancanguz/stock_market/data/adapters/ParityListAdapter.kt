package com.ozancanguz.stock_market.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.stock_market.R
import com.ozancanguz.stock_market.data.model.parity.Parity
import com.ozancanguz.stock_market.data.model.parity.Result
import com.ozancanguz.stock_market.ui.fragments.parity.ParityFragmentDirections
import kotlinx.android.synthetic.main.parity_row_layout.view.*

class ParityListAdapter:RecyclerView.Adapter<ParityListAdapter.ParityViewHolder>() {

    var parityList= emptyList<Result>()

    fun setData(newData:Parity){
        this.parityList=newData.result
        notifyDataSetChanged()
    }

    class ParityViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParityViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.parity_row_layout,parent,false)
        return ParityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParityViewHolder, position: Int) {
       val currentParity=parityList[position]
        holder.itemView.parity_name.text=currentParity.name
        holder.itemView.parity_text.text=currentParity.text


        holder.itemView.setOnClickListener {
            val action=ParityFragmentDirections.actionParityFragmentToParityDetails(currentParity)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return parityList.size
    }


}