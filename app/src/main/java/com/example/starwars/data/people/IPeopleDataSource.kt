package com.example.starwars.data.people

import com.example.starwars.data.common.ResultWrapper
import com.example.starwars.data.people.objects.People
import com.example.starwars.data.people.objects.PeopleListResponse
import com.example.starwars.data.people.objects.ResultListResponse

interface IPeopleDataSource {
    //Interfaces required for all objects in this data source.
    interface Common {

    }

    //Interfaces specific to remote data source
    interface Remote : Common {
        suspend fun getPeople() : ResultWrapper<ResultListResponse>
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
        suspend fun getCachedPeople(peopleNAME: String): ResultWrapper<People?>
        suspend fun getPeople(): PeopleListResponse?
    }
}