package com.example.starwars.data.planet

import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.planet.objects.Planet
import com.example.starwars.data.planet.objects.PlanetListResponse
import com.example.starwars.data.planet.remote.PlanetRemoteDataSource

object PlanetRepository : IPlanetDataSource.Main {
    private var cachedPlanetResponse: PlanetListResponse? = null

    override suspend fun getCachedPlanet(PlanetNAME: String): ResultWrapper<Planet?> {
        /*for (item in cachedPlanetResponse!!){
            if (item.name == monsterNAME){
                return ResultWrapper(item, null)
            }
        }*/

        return ResultWrapper(null, null)
    }

    override suspend fun getPlanet(): PlanetListResponse? {
        val result = PlanetRemoteDataSource.getPlanet()

        result.result?.let {
            //saveDetails(it)
            cachedPlanetResponse = it.list
        }

        return cachedPlanetResponse
    }
}