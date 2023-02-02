package com.example.api.retrofit

import com.example.api.model.Meme
import retrofit2.Call

import com.example.api.model.Tag
import com.example.api.model.Tag2
import retrofit2.http.*



interface MyApiService {

    @GET
    fun getMemeList(@Url url:String): Call<ArrayList<Meme>>

    @GET
    fun getMemeById(
        @Url url:String
    ): Call<Meme?>?
    @GET
    fun getTags(
        @Url url:String
    ): Call<ArrayList<Tag>>

    @POST
    fun postMeme(
        @Body meme: Meme
//        @Field("nombre") nombre: String?,
//        @Field("tituloSup") titluloSup: String?,
//        @Field("url") url: String?,
//        @Field("tituloInf") tituloInf: String?,
//        @Field("tags") tags: String?
    ): Call<Meme?>?



    @POST("/tag")
    fun postTag(
        @Body() tag : Tag
    ): Call<Tag2>


}