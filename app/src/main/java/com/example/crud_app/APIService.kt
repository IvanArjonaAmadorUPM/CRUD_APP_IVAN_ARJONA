package com.example.crud_app

import retrofit2.Response
import retrofit2.http.*
import okhttp3.ResponseBody
import retrofit2.Call

import retrofit2.http.DELETE





interface APIService {
    //Busqueda de usuario por ID
    @GET
    suspend fun getUserById(@Url url:String):Response<UserResponse>

    @DELETE("/api/User/{id}")
    fun deleteUser(@Path("id") id: String?): Call<ResponseBody?>?


}