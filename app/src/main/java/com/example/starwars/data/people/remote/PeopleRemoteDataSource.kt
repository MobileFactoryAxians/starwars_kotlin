package com.example.starwars.data.people.remote

import com.example.starwars.data.common.HTTPClient
import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.people.IPeopleDataSource
import com.example.starwars.data.people.objects.ResultPeopleResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object PeopleRemoteDataSource : IPeopleDataSource.Remote {

    private val peopleAPI = HTTPClient(PeopleAPI::class.java).get()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getPeople(): ResultWrapper<ResultPeopleResponse> {
        return ResultWrapper.safeApiCall(dispatcher) {
            peopleAPI.getPeople()
        }
    }
}