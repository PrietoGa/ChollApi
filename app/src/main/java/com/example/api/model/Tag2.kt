package com.example.api.model

import com.google.gson.annotations.SerializedName

data class Tag2(
    @SerializedName("idTag") val id: Int,
    @SerializedName("texto") val texto:String
)