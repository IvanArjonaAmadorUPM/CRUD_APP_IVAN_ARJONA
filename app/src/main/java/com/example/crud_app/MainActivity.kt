package com.example.crud_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crud_app.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
    /*Función que obtiene la url de la API externa
    y convierte los datos de JSON al modelo creado*/
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://hello-world.innocv.com/api/User/").
        addConverterFactory(GsonConverterFactory.create()).build()
    }

    /*creación de corrutinas para evitar que la aplicacion
    se bloquee al realizar peticiones al servidor*/
    private fun searchById(query:Int){
        CoroutineScope(Dispatchers.IO).launch {
            val call : Response<UserResponse> = getRetrofit().create(APIService::class.java).getUserById("$query")
            val user: UserResponse? = call.body()
            if(call.isSuccessful){
            //show recycled
            }
            else{
                //show error
            }
        }
    }
}