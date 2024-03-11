package com.example.starwars.data.people

import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.people.objects.People
import com.example.starwars.data.people.objects.PeopleListResponse
import com.example.starwars.data.people.objects.ResultListResponse
import com.example.starwars.data.people.remote.PeopleRemoteDataSource

object PeopleRepository : IPeopleDataSource.Main{
    private var cachedPeopleResponse: PeopleListResponse? = null

    override suspend fun getCachedPeople(peopleNAME: String): ResultWrapper<People?> {
        /*for (item in cachedPeopleResponse!!){
            if (item.name == monsterNAME){
                return ResultWrapper(item, null)
            }
        }*/

        return ResultWrapper(null, null)
    }

    override suspend fun getPeople(): PeopleListResponse? {
        val result = PeopleRemoteDataSource.getPeople()

        result.result?.let {
            //saveDetails(it)
            cachedPeopleResponse = it.list
        }

        return cachedPeopleResponse
    }
}