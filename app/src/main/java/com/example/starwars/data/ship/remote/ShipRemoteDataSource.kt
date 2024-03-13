package com.example.starwars.data.ship.remote

import com.example.starwars.data.common.HTTPClient
import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.ship.IShipDataSource
import com.example.starwars.data.ship.objects.ResultShipResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object ShipRemoteDataSource : IShipDataSource.Remote {

    private val ShipAPI = HTTPClient(ShipAPI::class.java).get()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getShip(): ResultWrapper<ResultShipResponse> {
        return ResultWrapper.safeApiCall(dispatcher) {
            ShipAPI.getShip()
        }
    }
}