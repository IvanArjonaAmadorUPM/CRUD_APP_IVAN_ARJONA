package com.example.crud_app

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*



interface APIService {
    //Busqueda de usuario por ID
    @GET
    suspend fun getUserById(@Url url:String):Response<UserResponse>

    @DELETE("/api/User/{id}")
    suspend fun deleteUser(@Path("id") id: Int?): Call<ResponseBody?>?

    @FormUrlEncoded
    @POST("createuser")
    fun createUser(
        @Field("name") name:String,
        @Field("birthdate") birthdate:String,
        @Field("id") id:String
    ):Call<ResponseBody>


}