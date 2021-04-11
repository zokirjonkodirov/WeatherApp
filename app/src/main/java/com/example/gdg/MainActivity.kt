package com.example.gdg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://api.weatherstack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(WeatherStackService::class.java)
        service.getCurrentWeather("7340a46c103c11fd9d09e05ab88f5275", "Tashkent"
        ).enqueue(object : Callback<currentWeatherResponce> {
            override fun onFailure(call: Call<currentWeatherResponce>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<currentWeatherResponce>, response: Response<currentWeatherResponce>) {
              val data = response.body()
                if (response.isSuccessful && data != null)
                {
                val temperature = data.current.temperature
                    val temperatureTextView = findViewById<TextView>(R.id.temperature)
                    temperatureTextView.setText("$temperature")
                }
            }

        })
    }
}