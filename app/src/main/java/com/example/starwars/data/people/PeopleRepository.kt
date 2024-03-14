package com.example.starwars.data.people

import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.people.objects.People
import com.example.starwars.data.people.objects.PeopleListResponse
import com.example.starwars.data.people.objects.ResultPeopleResponse
import com.example.starwars.data.people.remote.PeopleRemoteDataSource

object PeopleRepository : IPeopleDataSource.Main{
    private var cachedPeopleResponse: List<People>? = null

    override suspend fun getCachedPeople(peopleNAME: String): ResultWrapper<People?> {
        cachedPeopleResponse?.forEach {
                item ->
            if (item.name == peopleNAME) {
                return ResultWrapper(item, null)
            }
        }

        return ResultWrapper(null, null)
    }

    override suspend fun getPeople(): ResultWrapper<PeopleListResponse> {
        val result = PeopleRemoteDataSource.getPeople()

        result.result?.let {
            //saveDetails(it)
            cachedPeopleResponse = it
        }

        return result
    }
}