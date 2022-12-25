package com.ozancanguz.stock_market.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.stock_market.data.Repository
import com.ozancanguz.stock_market.data.model.crpto.Crypto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {


    var cryptoList=MutableLiveData<Crypto>()
    var job: Job?=null


    fun requestCryptoData(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getCryptoPrices()
            if(response.isSuccessful){
                cryptoList.postValue(response.body())
                Log.d("cryptoviewmodel","data retrieved successfully")
            }else{
                Log.d("cryptoviewmodel","data not found")
            }
        }
    }


}