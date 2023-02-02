package com.example.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MemePost (
    @SerializedName("nombre") val nombre:String,
    @SerializedName("tSuperior") val tituloSup:String,
    @SerializedName("tInferior") val tituloInf:String,
    @SerializedName("url") val url:String,
    @SerializedName("tags") val tags:String
):Serializable{
    override fun toString(): String {
        return "MemeGet(nombre='$nombre', tituloSup='$tituloSup', tituloInf='$tituloInf', url='$url', tags='$tags')"
    }


}