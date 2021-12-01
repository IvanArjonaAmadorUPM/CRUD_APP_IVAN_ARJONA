package com.example.crud_app
import retrofit2.*
import com.google.gson.annotations.SerializedName


data class UserResponse(@SerializedName("name") var status:String, @SerializedName("message") var images: List<String>)
