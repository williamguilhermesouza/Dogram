package tk.williamsouza.dogram.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tk.williamsouza.dogram.util.Constants.Companion.BASE_URL

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : DogApi by lazy {
        retrofit.create(DogApi::class.java)
    }
}