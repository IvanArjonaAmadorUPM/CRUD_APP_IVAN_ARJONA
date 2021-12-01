package com.example.crud_app
import retrofit2.*
import com.google.gson.annotations.SerializedName


data class UserResponse(
                        @SerializedName("name") var name:String,
                        @SerializedName("birthdate") var birthdate: String,
                        @SerializedName("id") var id:Int
                        )
