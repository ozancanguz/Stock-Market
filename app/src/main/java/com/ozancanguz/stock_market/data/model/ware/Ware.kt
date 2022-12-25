package com.ozancanguz.stock_market.data.model.ware


import com.google.gson.annotations.SerializedName

data class Ware(
    @SerializedName("result")
    val result: List<Result>
)