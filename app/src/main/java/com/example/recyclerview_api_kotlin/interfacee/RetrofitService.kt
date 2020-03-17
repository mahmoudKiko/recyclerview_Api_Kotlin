package com.example.recyclerview_api_kotlin.interfacee

import android.telecom.Call
import com.example.recyclerview_api_kotlin.model.Movie
import retrofit2.http.GET

interface RetrofitService{

    @GET("getBanner.php")
    fun getMovieList(): retrofit2.Call<MutableList<Movie>>

}