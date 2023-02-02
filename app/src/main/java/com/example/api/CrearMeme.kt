package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.api.model.Tag
import com.example.api.retrofit.MyApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CrearMeme : AppCompatActivity() {
    val adapter:MyApiAdapter = MyApiAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_meme)

        var tags:ArrayList<Tag> = arrayListOf()

        adapter.getApiService()!!.getTags("/tag")!!
            .enqueue(object : Callback<ArrayList<Tag>>{
                override fun onResponse(
                    call: Call<ArrayList<Tag>>,
                    response: Response<ArrayList<Tag>>
                ) {
                    tags = response.body()!!
                }

                override fun onFailure(call: Call<ArrayList<Tag>>, t: Throwable) {
                    Toast.makeText(this@CrearMeme, "Unable to connect to the API", Toast.LENGTH_SHORT).show()
                }

            })



        //val meme:Meme = Meme("", "", "" , "" , "")

    }
}


