package com.ozancanguz.stock_market.data.model.gold


import com.google.gson.annotations.SerializedName

data class Gold(
    @SerializedName("result")
    val result: List<Result>
)