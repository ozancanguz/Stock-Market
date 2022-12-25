package com.ozancanguz.stock_market.data.model.stock


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("code")
    val code: String,
    @SerializedName("hacim")
    val hacim: String,
    @SerializedName("hacimstr")
    val hacimstr: String,
    @SerializedName("lastprice")
    val lastprice: Double,
    @SerializedName("lastpricestr")
    val lastpricestr: String,
    @SerializedName("max")
    val max: Double,
    @SerializedName("maxstr")
    val maxstr: String,
    @SerializedName("min")
    val min: Double,
    @SerializedName("minstr")
    val minstr: String,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("text")
    val text: String,
    @SerializedName("time")
    val time: String
)