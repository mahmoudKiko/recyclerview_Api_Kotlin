package com.example.recyclerview_api_kotlin.common

import com.example.recyclerview_api_kotlin.interfacee.RetrofitService
import com.example.recyclerview_api_kotlin.retrofit.RetrofitClient
import retrofit2.create

object Common {


    private val   BASE_URL = "http://192.168.1.5/Android/v1/"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}