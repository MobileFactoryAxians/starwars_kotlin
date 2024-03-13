package com.example.starwars.data.planet.remote

import com.example.starwars.data.Planet.IPlanetDataSource
import com.example.starwars.data.common.HTTPClient
import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.planet.objects.ResultPlanetResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object PlanetRemoteDataSource : IPlanetDataSource.Remote {

    private val PlanetAPI = HTTPClient(PlanetAPI::class.java).get()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getPlanet(): ResultWrapper<ResultPlanetResponse> {
        return ResultWrapper.safeApiCall(dispatcher) {
            PlanetAPI.getPlanet()
        }
    }
}