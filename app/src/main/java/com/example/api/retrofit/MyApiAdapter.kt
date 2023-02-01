package com.example.api.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyApiAdapter {

    private var API_SERVICE: MyApiService? = null

    /**
     * Localhost IP for AVD emulators: 10.0.2.2
     */
    private val BASE_URL = "https://damemeapi.000webhostapp.com/"

    fun getApiService(): MyApiService? {
        // Creamos un interceptor y le indicamos el log level a usar
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        // Asociamos el interceptor a las peticiones
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        if (API_SERVICE == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()) // <-- set log level
                .build()
            API_SERVICE = retrofit.create(MyApiService::class.java)
        }
        return API_SERVICE
    }

}