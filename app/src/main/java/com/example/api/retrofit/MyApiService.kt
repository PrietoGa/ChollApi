package com.example.api.retrofit

import com.example.api.model.Meme
import retrofit2.Call
import retrofit2.http.*


interface MyApiService {

    @GET
    fun getMemeList(@Url url:String): Call<ArrayList<Meme>>

    @POST
    fun postMeme(
        @Field("nombre") nombre: String?,
        @Field("tituloSup") titluloSup: String?,
        @Field("url") url: String?,
        @Field("tituloInf") tituloInf: String?,
        @Field("tags") tags: String?
    ): Call<Meme?>?

    @GET
    fun getMemeById(
        @Url url:String
    ): Call<Meme?>?

    @POST
    fun postTag(@Body tag : Tag,
        @Field("nombre") nombre: String?
    ): Call<Tag>


}