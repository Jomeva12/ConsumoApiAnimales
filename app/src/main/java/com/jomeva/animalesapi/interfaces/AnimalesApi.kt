package com.jomeva.animalesapi.interfaces

import com.jomeva.animalesapi.modelos.AnimalesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AnimalesApi {
@GET("images")
    fun ontenerAnimales():AnimalesResponse
    companion object{
        val retrofit= Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/hound/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}