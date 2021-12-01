package com.example.crud_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud_app.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    private val userList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svUser.setOnQueryTextListener(this)
        initRecyclerView()

    }
    //inicializa la vista
    private fun initRecyclerView() {
        adapter = UserAdapter(userList)
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        binding.rvUser.adapter = adapter
    }

    /*Función que obtiene la url de la API externa
    y convierte los datos de JSON al modelo creado*/
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://hello-world.innocv.com/api/User/").
        addConverterFactory(GsonConverterFactory.create()).build()
    }

    /*creación de corrutinas para evitar que la aplicacion
    se bloquee al realizar peticiones al servidor
    se muestra la vista*/
    private fun searchById(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call : Response<UserResponse> = getRetrofit().create(APIService::class.java).getUserById("$query")
            val users: UserResponse? = call.body()
            runOnUiThread {
                if(call.isSuccessful){

                    val usuario = users?.name
                    userList.clear()
                    userList.add(usuario.toString())
                    adapter.notifyDataSetChanged()
                }
                else{
                    showError()
                }
            }

        }
    }
    private fun showError(){
        Toast.makeText(this,"No puede mostrarse el usuario ",Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            searchById(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}