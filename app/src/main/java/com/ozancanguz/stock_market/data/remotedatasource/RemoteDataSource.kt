package com.ozancanguz.stock_market.data.remotedatasource

import com.ozancanguz.stock_market.data.api.StockApi
import com.ozancanguz.stock_market.data.model.crpto.Crypto
import com.ozancanguz.stock_market.data.model.gold.Gold
import com.ozancanguz.stock_market.data.model.parity.Parity
import com.ozancanguz.stock_market.data.model.stock.Stock
import com.ozancanguz.stock_market.data.model.ware.Ware
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val stockApi: StockApi) {


    suspend fun getGoldPrices(): Response<Gold> {
        return stockApi.getGoldPrices()
    }


    suspend fun getCryptoPrices():Response<Crypto>{
        return stockApi.getCryptoPrices()
    }

    suspend fun getStockPrices():Response<Stock>{
        return stockApi.getStockPrices()
    }

    suspend fun getParityPrices():Response<Parity>{
        return stockApi.getParityPrices()
    }

    suspend fun getWarePrices():Response<Ware>{
        return stockApi.getWarePrices()
    }

}