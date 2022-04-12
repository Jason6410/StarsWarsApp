package com.example.starswarsapp.data

import com.example.starswarsapp.model.PeopleList
import com.example.starswarsapp.model.PlanetList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface StarWarsService {

    @GET("planets")
    @Headers("Content-Type: application/json")
    fun getPlanets(): Call<PlanetList>


    @GET("people")
    @Headers("Content-Type: application/json")
    fun getPeople(): Call<PeopleList>
}