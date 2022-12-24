package com.ozancanguz.stock_market.data.remotedatasource

import com.ozancanguz.stock_market.data.api.StockApi
import com.ozancanguz.stock_market.data.model.gold.Gold
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val stockApi: StockApi) {


    suspend fun getGoldPrices(): Response<Gold> {
        return stockApi.getGoldPrices()
    }



}