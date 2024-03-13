package com.example.starwars.data.ship.objects

import com.example.starwars.data.ship.objects.ShipListResponse
import com.google.gson.annotations.SerializedName

data class ResultShipResponse(
    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val list : ShipListResponse
)