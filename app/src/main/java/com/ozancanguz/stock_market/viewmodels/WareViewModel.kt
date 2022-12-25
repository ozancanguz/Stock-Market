package com.ozancanguz.stock_market.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.stock_market.data.Repository
import com.ozancanguz.stock_market.data.model.ware.Ware
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WareViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {

    var wareList=MutableLiveData<Ware>()
    var job: Job?=null

    fun requestWareData(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getWarePrices()
            if(response.isSuccessful){
                wareList.postValue(response.body())
                Log.d("wareviewmodel","data retrieved succesfully")
            }else{
                Log.d("wareviewmodel","data not found")
            }
        }
    }


}