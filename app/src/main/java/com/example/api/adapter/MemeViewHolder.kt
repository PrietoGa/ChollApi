package com.example.api.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.R
import com.example.api.model.Meme
import com.squareup.picasso.Picasso

class MemeViewHolder(val v: View):RecyclerView.ViewHolder(v) {

    fun render(meme:Meme){
        v.findViewById<TextView>(R.id.cardTituloSup).text = meme.tituloSup
        v.findViewById<TextView>(R.id.cardTituloInf).text = meme.tituloInf
        v.findViewById<TextView>(R.id.cardNombreMeme).text = meme.nombre
        if(meme.url!="")
            Picasso.get().load(meme.url).into(v.findViewById<ImageView>(R.id.cardImageView))
        else
            v.findViewById<ImageView>(R.id.cardImageView).setImageResource(R.drawable.ic_launcher_foreground)
    }
}