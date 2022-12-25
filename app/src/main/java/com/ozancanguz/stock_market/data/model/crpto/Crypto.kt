package com.ozancanguz.stock_market.data.model.crpto


import com.google.gson.annotations.SerializedName

data class Crypto(
    @SerializedName("result")
    val result: List<Result>
)