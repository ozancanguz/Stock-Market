package com.ozancanguz.stock_market.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.stock_market.data.Repository
import com.ozancanguz.stock_market.data.model.stock.Stock
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application){


    var stockList= MutableLiveData<Stock>()
    var job: Job?=null

    fun getStockPrices(){
        job= CoroutineScope(Dispatchers.IO).launch{

            val response=repository.remote.getStockPrices()
            if(response.isSuccessful){
                stockList.postValue(response.body())
                Log.d("stockViewModel","Data retrived succesfully")
            }else{
                Log.d("stockViewModel","Data not found")
            }
        }
    }





}