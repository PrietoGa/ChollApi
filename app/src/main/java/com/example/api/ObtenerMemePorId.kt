package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.api.databinding.ActivityObtenerMemePorIdBinding
import com.example.api.model.Meme
import com.example.api.retrofit.MyApiAdapter
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ObtenerMemePorId : AppCompatActivity() {

    private lateinit var binding: ActivityObtenerMemePorIdBinding
    val adapter:MyApiAdapter = MyApiAdapter()
    val context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityObtenerMemePorIdBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var id:Int = intent.getIntExtra("id", -1)
        if(id!=null && id!=-1){
            renderMeme("$id")
        }


        binding.imprimirMeme.setOnClickListener{
            renderMeme()
        }

    }

    fun renderMeme(id: String = binding.idMeme.text.toString()){
         adapter.getApiService()!!.getMemeById("/meme?id=$id")!!
             .enqueue(object : Callback<Meme?> {
                 override fun onResponse(call: Call<Meme?>, response: Response<Meme?>) {
                     if (response.body() != null) {
                         binding.tituloSup.text = response.body()?.tituloSup
                         binding.tituloInf.text = response.body()?.tituloInf
                         binding.nombreMeme.text = response.body()?.nombre
                         if(response.body()?.url!="")
                            Picasso.get().load(response.body()?.url).into(binding.imageView)
                         else
                             binding.imageView.setImageResource(R.drawable.ic_launcher_foreground)
                     } else {
                         return
                     }
                 }
                 override fun onFailure(call: Call<Meme?>, t: Throwable) {
                     Toast.makeText(context, "ERROR AL CARGAR LA PAGINA", Toast.LENGTH_SHORT).show()
                 }
             })
    }
    fun render(meme:Meme){
        binding.tituloSup.text = meme.tituloSup
        binding.tituloInf.text = meme.tituloInf
        binding.nombreMeme.text = meme.nombre
        if(meme.url!="")
            Picasso.get().load(meme.url).into(binding.imageView)
        else
            binding.imageView.setImageResource(R.drawable.ic_launcher_foreground)
    }

}


