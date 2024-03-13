package com.example.starwars.data.planet.objects

import com.google.gson.annotations.SerializedName

data class ResultPlanetResponse(
    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val list : PlanetListResponse
)