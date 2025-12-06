package com.example.test_lab_week_12

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieApplication : Application() {
    lateinit var movieRepository: MovieRepository
    override fun onCreate() {
        super.onCreate()
// create a Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://204218a774bd.ngrok-free.app")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
// create a MovieService instance
// and bind the MovieService interface to the Retrofit instance
// this allows us to make API calls
        val movieService = retrofit.create(
            MovieService::class.java
        )
// create a MovieRepository instance
        movieRepository = MovieRepository(movieService as com.example.test_lab_week_12.MovieService)
    }
}
