package com.jomeva.animalesapi.interfaces

import com.jomeva.animalesapi.modelos.AnimalesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface AnimalesApi {

    @GET
   suspend fun obtenerAnimales(@Url url: String):Response<AnimalesResponse>

    companion object{
        val retrofit= Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}