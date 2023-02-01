package com.example.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val obtenerMemePorId = binding.buscar
        val listaDeMemes = binding.verMemes
        val crearTag = binding.crearTAG
        val crearMeme = binding.crearMeme

        obtenerMemePorId.setOnClickListener{ startActivity(Intent(this, ObtenerMemePorId::class.java)) }
        listaDeMemes.setOnClickListener{ startActivity(Intent(this, ListaDeMemes::class.java)) }
        crearTag.setOnClickListener{ startActivity(Intent(this, CrearTag::class.java)) }
        crearMeme.setOnClickListener{ startActivity(Intent(this, CrearMeme::class.java)) }

    }

}