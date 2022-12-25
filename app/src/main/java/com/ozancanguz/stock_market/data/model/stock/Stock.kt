package com.ozancanguz.stock_market.data.model.stock


import com.google.gson.annotations.SerializedName

data class Stock(
    @SerializedName("result")
    val result: List<Result>
)