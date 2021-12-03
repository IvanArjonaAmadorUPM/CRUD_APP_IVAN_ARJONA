package com.example.crud_app

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_app.databinding.ItemUserBinding

class UserViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemUserBinding.bind(view)
    fun bin(user:String){
        binding.ivUser1.text = user
        binding.ivUser1.text = user
        binding.ivUser1.text = user
    }
}