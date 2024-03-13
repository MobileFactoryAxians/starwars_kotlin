package com.example.starwars.data.ship

import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.ship.objects.Ship
import com.example.starwars.data.ship.objects.ShipListResponse
import com.example.starwars.data.ship.remote.ShipRemoteDataSource

object ShipRepository : IShipDataSource.Main {
    private var cachedShipResponse: ShipListResponse? = null

    override suspend fun getCachedShip(ShipNAME: String): ResultWrapper<Ship?> {
        /*for (item in cachedShipResponse!!){
            if (item.name == monsterNAME){
                return ResultWrapper(item, null)
            }
        }*/

        return ResultWrapper(null, null)
    }

    override suspend fun getShip(): ShipListResponse? {
        val result = ShipRemoteDataSource.getShip()

        result.result?.let {
            //saveDetails(it)
            cachedShipResponse = it.list
        }

        return cachedShipResponse
    }
}