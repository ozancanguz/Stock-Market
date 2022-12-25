package com.ozancanguz.stock_market.data.api

import com.ozancanguz.stock_market.data.model.crpto.Crypto
import com.ozancanguz.stock_market.data.model.gold.Gold
import com.ozancanguz.stock_market.data.model.stock.Stock
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface StockApi {

    // get gold price data
    @Headers(
        "authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn",
        "content-type: application/json"
    )
    @GET("goldPrice")
    suspend fun getGoldPrices(): Response<Gold>


    // get crypto data
    @Headers(
        "authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn",
        "content-type: application/json"
    )
    @GET("cripto")
    suspend fun getCryptoPrices(): Response<Crypto>


    // get stock data
    @Headers(
        "authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn",
        "content-type: application/json"
    )
    @GET("hisseSenedi")
    suspend fun getStockPrices(): Response<Stock>
}