package com.example.crud_app

import retrofit2.Response
import retrofit2.http.*


interface APIService {

    @GET
    fun getUserById(@Url url:String):Response<UserResponse>

}