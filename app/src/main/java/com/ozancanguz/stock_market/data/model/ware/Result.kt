package com.ozancanguz.stock_market.data.model.ware


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
    val rate: String,
    @SerializedName("selling")
    val selling: Double,
    @SerializedName("sellingstr")
    val sellingstr: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("time")
    val time: String
):Parcelable