package com.example.api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.api.R
import com.example.api.model.Meme

class MemeAdapter(var lista: ArrayList<Meme>)  : RecyclerView.Adapter<MemeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        return MemeViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.item_lista_meme, parent, false))
    }
    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        holder.render(lista[position])
    }
    override fun getItemCount(): Int {
        return lista.size
    }

}