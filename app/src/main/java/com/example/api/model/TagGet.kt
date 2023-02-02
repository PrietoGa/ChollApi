package com.example.api.model

import com.google.gson.annotations.SerializedName

data class TagGet(
    @SerializedName("idTag") val id: Int,
    @SerializedName("texto") val texto:String

) {
    override fun toString(): String {
        return " $texto "
    }
    fun id(): String {
        return " $id "
    }
}