package com.example.api.model

import com.google.gson.annotations.SerializedName

data class Meme(
    @SerializedName("idMeme") val id:Int,
    @SerializedName("nombre") val nombre:String,
    @SerializedName("tSuperior") val tituloSup:String,
    @SerializedName("tInferior") val tituloInf:String,
    @SerializedName("url") val url:String,
    @SerializedName("tags") val tags:String
    )