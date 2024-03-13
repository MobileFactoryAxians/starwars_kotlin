package com.example.starwars.data.Planet

import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.planet.objects.Planet
import com.example.starwars.data.planet.objects.PlanetListResponse
import com.example.starwars.data.planet.objects.ResultPlanetResponse

interface IPlanetDataSource {
    //Interfaces required for all objects in this data source.
    interface Common {

    }

    //Interfaces specific to remote data source
    interface Remote : Common {
        suspend fun getPlanet() : ResultWrapper<ResultPlanetResponse>
        //suspend fun checkSession() : ResultWrapper<CheckSessionResponse>
    }

    //interfaces specific to local data source
    interface Local : Common {
        /*suspend fun getDetails() : ResultWrapper<LoginResponse>
        suspend fun saveDetails(data: LoginResponse)
        suspend fun logout() : ResultWrapper<Unit>*/
    }

    //interfaces specific to the main repository object. (cache operations, for example). Inherits both Remote and Local as those data sources are accessed by use cases via the repository.
    interface Main {
        suspend fun getCachedPlanet(PlanetNAME: String): ResultWrapper<Planet?>
        suspend fun getPlanet(): PlanetListResponse?
    }
}