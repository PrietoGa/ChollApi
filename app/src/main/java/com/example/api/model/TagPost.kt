package com.example.api.model

import com.google.gson.annotations.SerializedName

data class TagPost(
    @SerializedName("id") val id: Int,
    @SerializedName("tagNombre") val texto:String
    )