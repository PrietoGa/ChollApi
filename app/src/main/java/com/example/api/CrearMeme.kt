package com.example.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.api.databinding.ActivityCrearMemeBinding
import com.example.api.model.Meme
import com.example.api.model.MemePost
import com.example.api.model.TagGet
import com.example.api.retrofit.MyApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CrearMeme : AppCompatActivity() {
    val adapter:MyApiAdapter = MyApiAdapter()
    private lateinit var binding: ActivityCrearMemeBinding
    var tagString:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearMemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tags:ArrayList<TagGet>


        adapter.getApiService()!!.getTags("/tag")!!
            .enqueue(object : Callback<ArrayList<TagGet>>{
                override fun onResponse(
                    call: Call<ArrayList<TagGet>>,
                    response: Response<ArrayList<TagGet>>
                ) {

                    tags = response.body()!!
                    binding.spinner.adapter = ArrayAdapter(this@CrearMeme,
                        android.R.layout.simple_spinner_dropdown_item,tags)

                }

                override fun onFailure(call: Call<ArrayList<TagGet>>, t: Throwable) {
                    Toast.makeText(this@CrearMeme, "Unable to connect to the API", Toast.LENGTH_SHORT).show()
                }

            })
        binding.anadirTag.setOnClickListener{
            tagString += " "+(binding.spinner.selectedItem as TagGet).id()+" ,"
            println(tagString)
        }

        binding.crearMeme.setOnClickListener{
            if(tagString.length>0) {
                println(tagString)
                tagString = tagString.substring(0, tagString.length - 1)
                println(tagString)
            }else {
                tagString = " 1 "
                println(tagString+" <=0")
            }
            val meme: MemePost = MemePost( binding.nombre.text.toString(), binding.titSup.text.toString(),
            binding.titInf.text.toString(), binding.url.text.toString(), tagString)
            adapter.getApiService()!!.postMeme(meme)!!
                .enqueue(object : Callback<Meme?>{
                    override fun onResponse(call: Call<Meme?>, response: Response<Meme?>) {
                        Toast.makeText(this@CrearMeme, "Meme creado", Toast.LENGTH_SHORT).show()
                        println(response.body())
                        startActivity(Intent(this@CrearMeme, ObtenerMemePorId::class.java).apply {
                            putExtra("id", response.body()?.id)
                        })
                    }

                    override fun onFailure(call: Call<Meme?>, t: Throwable) {
                        Toast.makeText(this@CrearMeme, "ERROR", Toast.LENGTH_SHORT).show()
                    }

                })
        }

    }
}


