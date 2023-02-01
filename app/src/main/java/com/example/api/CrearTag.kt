package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api.databinding.ActivityCrearTagBinding
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

    fun crearTag(){/*
        val tag = Tag(0, "nuevotag")
        MyApiAdapter().getApiService()!!.postTag(tag)
            .enqueue(object : Callback<Tag>{
                override fun onResponse(call: Call<Tag>, response: Response<Tag>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<Tag>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })*/
    }
}