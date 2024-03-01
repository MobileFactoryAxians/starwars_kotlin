package com.example.starwars.data.people.remote

import com.example.starwars.data.common.HTTPClient
import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.people.IPeopleDataSource
import com.example.starwars.data.people.objects.PeopleListResponse
import com.example.starwars.data.people.objects.ResultListResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object PeopleRemoteDataSource : IPeopleDataSource.Remote {

    private val peopleAPI = HTTPClient(PeopleAPI::class.java).get()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getPeople(): ResultWrapper<ResultListResponse> {
        return ResultWrapper.safeApiCall(dispatcher) {
            peopleAPI.getPeople()
        }
    }
}