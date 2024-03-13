package com.example.starwars.data.ship.remote

import com.example.starwars.data.ship.objects.ResultShipResponse
import retrofit2.http.GET

interface ShipAPI {
    @GET("starships")
    suspend fun getShip() : ResultShipResponse
}