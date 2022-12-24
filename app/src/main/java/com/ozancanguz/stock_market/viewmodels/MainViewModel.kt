package com.ozancanguz.stock_market.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.stock_market.data.Repository
import com.ozancanguz.stock_market.data.model.gold.Gold
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application) {


    var goldPriceList= MutableLiveData<Gold>()
    var job: Job?=null

    fun requestGoldPrices(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getGoldPrices()
            if(response.isSuccessful){
                goldPriceList.postValue(response.body())
                Log.d("viewmodel2","" +response.body())
            }
            else{
                Log.d("viewmodel","data not found")
            }
        }
    }




}