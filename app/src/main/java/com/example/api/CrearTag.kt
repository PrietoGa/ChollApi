package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.api.databinding.ActivityCrearTagBinding
import com.example.api.model.TagGet
import com.example.api.model.TagPost
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


        MyApiAdapter().getApiService()!!.postTag(TagPost(0,binding.nuevoTag.text.toString()))
            .enqueue(object : Callback<TagGet>{
                override fun onResponse(call: Call<TagGet>, response: Response<TagGet>) {

                    if(response.body()!!.texto==null) {
                        print("TAG ya existente")
                        Toast.makeText(this@CrearTag, "TAG ya existente", Toast.LENGTH_SHORT).show()
                    }else {
                        print("TAG creado")
                        Toast.makeText(this@CrearTag, "TAG creado", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<TagGet>, t: Throwable) {
                    println("Error al crear el  TAG")
                    Toast.makeText(this@CrearTag, "ERROR", Toast.LENGTH_SHORT).show()

                }

            })
    }
}