package com.example.api.model

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre:String
    )