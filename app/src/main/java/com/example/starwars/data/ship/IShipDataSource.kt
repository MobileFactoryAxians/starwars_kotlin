package com.example.starwars.data.ship

import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.ship.objects.Ship
import com.example.starwars.data.ship.objects.ShipListResponse
import com.example.starwars.data.ship.objects.ResultShipResponse

interface IShipDataSource {
    //Interfaces required for all objects in this data source.
    interface Common {

    }

    //Interfaces specific to remote data source
    interface Remote : Common {
        suspend fun getShip() : ResultWrapper<ResultShipResponse>
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
        suspend fun getCachedShip(ShipNAME: String): ResultWrapper<Ship?>
        suspend fun getShip(): ShipListResponse?
    }
}