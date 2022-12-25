package com.ozancanguz.stock_market.data.model.parity


import com.google.gson.annotations.SerializedName

data class Parity(
    @SerializedName("result")
    val result: List<Result>
)