package com.example.crud_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val users:List<String>):RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    //retorna el objeto en la posicion obtenida
    override fun onBindViewHolder(holder: UserViewHolder, position: Int)  {
        val item = users[position]
        holder.bin(item)

    }
    //retorna el numero de usuarios
    override fun getItemCount(): Int = users.size

}