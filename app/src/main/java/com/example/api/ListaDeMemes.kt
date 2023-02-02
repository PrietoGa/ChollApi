package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.adapter.MemeAdapter
import com.example.api.databinding.ActivityListaDeMemesBinding
import com.example.api.model.Meme
import com.example.api.retrofit.MyApiAdapter
import com.example.api.vm.DataViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaDeMemes : AppCompatActivity() {


    private lateinit var binding: ActivityListaDeMemesBinding
    val vm:DataViewModel by viewModels()
    lateinit var rv:RecyclerView
    var page:Int = 0
    val context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaDeMemesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rv = binding.rv
        //Introducimos la lista en el viewModel
        rv.layoutManager = LinearLayoutManager(this)


//        vm.memes.observe(this, Observer { newAdaoter ->
//            rv.adapter =  MemeAdapter(newAdaoter)
//            rv.adapter!!.notifyDataSetChanged()
//        })
        cargar()
        print("\n\n memes ${vm.memes().size}\n\n")

        binding.anteriores.setOnClickListener{
            anterior()
        }
        binding.siguientes.setOnClickListener{
            siguiente()
        }
    }
    fun cargar(){
        MyApiAdapter().getApiService()!!.getMemeList("/meme/list?page=$page?count=5")!!
            .enqueue(object : Callback<ArrayList<Meme>> {
                override fun onResponse(
                    call: Call<ArrayList<Meme>>,
                    response: Response<ArrayList<Meme>>
                ) {
                    vm.setMemes(response.body())
                    rv.adapter = MemeAdapter(vm.memes())
                    rv.adapter!!.notifyDataSetChanged()

                }
                override fun onFailure(call: Call<ArrayList<Meme>>, t: Throwable) {
                    Toast.makeText(context, "ERROR AL CARGAR LA PAGINA", Toast.LENGTH_SHORT).show()
                }

            })

    }
    fun siguiente(){
        page +=1
        cargar()
    }
    fun anterior(){
        if(page>0)
            page -=1
        cargar()
    }
}