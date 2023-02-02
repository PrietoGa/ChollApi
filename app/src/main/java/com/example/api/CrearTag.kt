package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.api.databinding.ActivityCrearTagBinding
import com.example.api.model.Tag2
import com.example.api.model.Tag
import com.example.api.retrofit.MyApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CrearTag : AppCompatActivity() {

    lateinit var binding: ActivityCrearTagBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCrearTagBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.crearTag.setOnClickListener{
            crearTag()
        }
    }

    fun crearTag(){


        MyApiAdapter().getApiService()!!.postTag(Tag(0,binding.nuevoTag.text.toString()))
            .enqueue(object : Callback<Tag2>{
                override fun onResponse(call: Call<Tag2>, response: Response<Tag2>) {
                    println("CREANDO TAG")
                    Toast.makeText(this@CrearTag, "Creado", Toast.LENGTH_SHORT).show()
                    println( "\n\nHUGYTYDR"+response.body()!!.texto)
                    if(response.body()!!.texto==null)
                        print("ESNULL\n\n\nESNULL")
                    else
                        print("NOESNULL\n\n\n\nNOESNULL")
                }

                override fun onFailure(call: Call<Tag2>, t: Throwable) {
                    println("Error al crear el  TAG")
                    Toast.makeText(this@CrearTag, "ERROR", Toast.LENGTH_SHORT).show()

                }

            })
    }
}