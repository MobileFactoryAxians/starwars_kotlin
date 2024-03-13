package com.example.starwars.data.planet.remote

import com.example.starwars.data.planet.objects.ResultPlanetResponse
import retrofit2.http.GET

interface PlanetAPI {
    @GET("planets")
    suspend fun getPlanet() : ResultPlanetResponse
}