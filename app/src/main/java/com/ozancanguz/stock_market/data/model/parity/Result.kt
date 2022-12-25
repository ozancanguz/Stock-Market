package com.ozancanguz.stock_market.data.model.parity


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("buying")
    val buying: Double,
    @SerializedName("buyingstr")
    val buyingstr: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rate")
    val rate: Any,
    @SerializedName("selling")
    val selling: Double,
    @SerializedName("sellingstr")
    val sellingstr: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("time")
    val time: String
)