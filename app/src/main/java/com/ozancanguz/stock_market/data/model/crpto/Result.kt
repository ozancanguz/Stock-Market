package com.ozancanguz.stock_market.data.model.crpto


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("changeDay")
    val changeDay: Double,
    @SerializedName("changeDaystr")
    val changeDaystr: String,

    @SerializedName("changeHourstr")
    val changeHourstr: String,
    @SerializedName("changeWeek")
    val changeWeek: Double,
    @SerializedName("changeWeekstr")
    val changeWeekstr: String,
    @SerializedName("circulatingSupply")
    val circulatingSupply: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("marketCap")
    val marketCap: Double,
    @SerializedName("marketCapstr")
    val marketCapstr: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("pricestr")
    val pricestr: String,
    @SerializedName("volume")
    val volume: Double,
    @SerializedName("volumestr")
    val volumestr: String
)