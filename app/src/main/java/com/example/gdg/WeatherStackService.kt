package com.example.gdg

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherStackService {
    @GET("current")
    fun getCurrentWeather(
            @Query("access_key") accessKey: String,
            @Query("query") location: String
    ) : retrofit2.Call<currentWeatherResponce>
}