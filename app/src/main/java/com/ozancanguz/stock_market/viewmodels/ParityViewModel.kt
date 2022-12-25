package com.ozancanguz.stock_market.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.stock_market.data.Repository
import com.ozancanguz.stock_market.data.model.parity.Parity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ParityViewModel@Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application) {


    var parityList=MutableLiveData<Parity>()
    var job: Job?=null

    fun requestParityData(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getParityPrices()
            if(response.isSuccessful){
                parityList.postValue(response.body())
                Log.d("parityviewmodel","Data retrieved succesfully")
                Log.d("parityviewModel",""+response.body())
            }else{
                Log.d("parityviewmodel","data not found")
            }
        }

    }



}