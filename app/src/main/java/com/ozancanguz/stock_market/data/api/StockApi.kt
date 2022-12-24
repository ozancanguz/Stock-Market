package com.ozancanguz.stock_market.data.api

import com.ozancanguz.stock_market.data.model.gold.Gold
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface StockApi {

    @Headers(
        "authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn",
        "content-type: application/json"
    )
    @GET("goldPrice")
    suspend fun getGoldPrices(): Response<Gold>
}