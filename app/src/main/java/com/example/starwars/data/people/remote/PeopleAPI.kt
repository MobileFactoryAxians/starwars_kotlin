package com.example.starwars.data.people.remote

import com.example.starwars.data.people.objects.ResultPeopleResponse
import retrofit2.http.GET

interface PeopleAPI {
    @GET("people")
    suspend fun getPeople() : ResultPeopleResponse
}