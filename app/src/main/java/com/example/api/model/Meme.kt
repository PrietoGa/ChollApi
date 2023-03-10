package com.example.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Meme (
    @SerializedName("idMeme") val id:Int,
    @SerializedName("nombre") val nombre:String,
    @SerializedName("tSuperior") val tituloSup:String,
    @SerializedName("tInferior") val tituloInf:String,
    @SerializedName("url") val url:String
    ):Serializable{
    override fun toString(): String {
        return "Meme(id=$id, nombre='$nombre', tituloSup='$tituloSup'," +
                " tituloInf='$tituloInf', url='$url')"
    }


}